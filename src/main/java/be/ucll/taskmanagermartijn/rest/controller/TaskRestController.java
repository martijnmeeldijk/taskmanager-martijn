package be.ucll.taskmanagermartijn.rest.controller;

import be.ucll.taskmanagermartijn.dto.TaskDTO;
import be.ucll.taskmanagermartijn.service.TaskService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class TaskRestController {

    private final TaskService taskService;

    public TaskRestController(@Qualifier("TaskServiceJPA") TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task")
    @ResponseBody
    public List<TaskDTO> getTasks() {
        return taskService.getTasks();
    }

    @PostMapping("/task")
    public TaskDTO createNewTask(@RequestBody @Valid TaskDTO taskDTO){

        taskService.addTask(taskDTO);
        return taskDTO;
    }
}
