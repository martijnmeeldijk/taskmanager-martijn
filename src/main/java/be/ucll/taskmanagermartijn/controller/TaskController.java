package be.ucll.taskmanagermartijn.controller;

import be.ucll.taskmanagermartijn.domain.Subtask;
import be.ucll.taskmanagermartijn.domain.Task;
import be.ucll.taskmanagermartijn.dto.SubtaskDTO;
import be.ucll.taskmanagermartijn.dto.TaskDTO;
import be.ucll.taskmanagermartijn.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class TaskController {
    @Qualifier("TaskServiceJPA")
    @Autowired
    TaskService tasks;

    @GetMapping("/")
    public String root() {
        return "redirect:/tasks";
    }

    /* GET TASKS */
    @GetMapping("/tasks")
    public String printTasks(Model model) {
        model.addAttribute("tasks", tasks.getTasks());
        return "tasks";
    }
    @GetMapping("/tasks/{id}")
    public String printDetails(Model model, @PathVariable("id") int id) {
        model.addAttribute("task", tasks.getTaskById(id));
        model.addAttribute("subtasks", tasks.getTaskById(id).getSubtasks());
        return "details";
    }

    /* DELETE TASKS*/
    @GetMapping("/tasks/delete/{id}")
    public String deleteTask(Model model, @PathVariable("id") int id) {
        tasks.deleteTaskById(id);
        return "redirect:/tasks";
    }

    /* CREATE TASKS */
    @GetMapping("/tasks/new")
    public String newTaskPage(Model model) {
        model.addAttribute(new TaskDTO());
        model.addAttribute("title", "New Task");
        return "newTask";
    }
    @PostMapping("/tasks/create")
    public String newTask(@ModelAttribute @Valid TaskDTO task, BindingResult bindingResult, Model model){
        if(bindingResult.hasErrors()){
            model.addAttribute("title", "New Task");
            return "newTask";
        }
        tasks.addTask(task);
        return "redirect:/tasks";
    }

    /* EDIT TASKS */
    @GetMapping("/tasks/edit/{id}")
    public String editPage(Model model, @PathVariable("id") int id) {
        model.addAttribute(tasks.getTaskDTOById(id));
        model.addAttribute("title", "Edit Task");
        model.addAttribute("edit", true);
        return "newTask";
    }
    @PostMapping("/tasks/edit")
    public String edit(TaskDTO task) {

        tasks.editTaskByTaskDTO(task);

        return "redirect:/tasks";
    }

    /* SUBTASKS */
    @GetMapping("/tasks/{id}/sub/create")
    public String addSubTaskPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("task", tasks.getTaskDTOById(id));
        model.addAttribute("subtask", new SubtaskDTO());

        return "newSubtask";
    }

    @PostMapping("/tasks/{id}/sub/create")
    public String addSubtask(Model model, @PathVariable("id") int id, @ModelAttribute @Valid SubtaskDTO subtask, BindingResult bindingResult) {


        if(bindingResult.hasErrors()){
            return "newSubtask";
        }
        tasks.addSubtask(id, subtask);
        model.addAttribute("task", tasks.getTaskDTOById(id));
        return "redirect:/tasks/{id}";
    }

    @GetMapping("/tasks/{id}/sub/delete/{subtaskId}")
    public String deleteSubtask(Model model, @PathVariable("id") int id, @PathVariable("subtaskId") int subtaskId) {
        tasks.deleteSubtask(id, subtaskId);
        model.addAttribute("task", tasks.getTaskById(id));
        model.addAttribute("subtask", new Subtask());

        return "redirect:/tasks/" + id;
    }
}
