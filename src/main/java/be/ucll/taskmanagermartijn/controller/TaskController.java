package be.ucll.taskmanagermartijn.controller;

import be.ucll.taskmanagermartijn.domain.Subtask;
import be.ucll.taskmanagermartijn.domain.Task;
import be.ucll.taskmanagermartijn.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
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
        model.addAttribute(new Task());
        model.addAttribute("title", "New Task");
        return "newTask";
    }
    @PostMapping("/tasks/create")
    public String newTask(@ModelAttribute @Valid Task task, BindingResult bindingResult, Model model){
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
        model.addAttribute(tasks.getTaskById(id));
        model.addAttribute("title", "Edit Task");
        model.addAttribute("edit", true);
        return "newTask";
    }
    @PostMapping("/tasks/edit")
    public String edit(Task task) {

        tasks.editTask(task);

        return "redirect:/tasks";
    }

    /* SUBTASKS */
    @GetMapping("/tasks/{id}/sub/create")
    public String addSubTaskPage(Model model, @PathVariable("id") int id) {
        model.addAttribute("task", tasks.getTaskById(id));
        model.addAttribute("subtask", new Subtask());

        return "newSubtask";
    }

    @PostMapping("/tasks/{id}/sub/create")
    public String addSubTask(Model model, @PathVariable("id") int id, @ModelAttribute @Valid Subtask subtask, BindingResult bindingResult) {
        model.addAttribute("task", tasks.getTaskById(id));
        if(bindingResult.hasErrors()){
            return "newSubtask";
        }
        tasks.addSubtask(id, subtask);
        return "redirect:/tasks/{id}";
    }

    @GetMapping("/tasks/{id}/sub/delete/{subtitle}")
    public String deleteSubtask(Model model, @PathVariable("id") int id, @PathVariable("subtitle") String subtitle) {
        tasks.getTaskById(id).deleteSubtask(subtitle);
        model.addAttribute("task", tasks.getTaskById(id));
        model.addAttribute("subtask", new Subtask());

        return "redirect:/tasks/" + id;
    }
}
