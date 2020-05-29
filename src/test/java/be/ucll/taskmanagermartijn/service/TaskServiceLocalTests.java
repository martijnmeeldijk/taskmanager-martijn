package be.ucll.taskmanagermartijn.service;

import be.ucll.taskmanagermartijn.dto.SubtaskDTO;
import be.ucll.taskmanagermartijn.dto.TaskDTO;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskServiceLocalTests {
    @Test
    public void testTaskServiceLocal() {

        TaskService tasks = new TaskServiceLocal();


        TaskDTO task = new TaskDTO();
        task.setId(1);
        task.setDateTime(LocalDateTime.now());
        task.setDescription("zaezergezrg");
        task.setTitle("aegfzerge");
        SubtaskDTO subtask = new SubtaskDTO();
        subtask.setId(2);
        subtask.setDescription("yolo");
        subtask.setTitle("coole titel");

        tasks.addTask(task);

        assertEquals(4, tasks.getTasks().size()); // ook seeds meetellen
        assertNotNull(tasks.getTaskDTOById(1));
        tasks.addSubtask(task.getId(), subtask);
        tasks.deleteTaskById(task.getId());
        assertEquals(3, tasks.getTasks().size()); // ook seeds meetellen
        tasks.addTask("azrfazef", "zafzae", LocalDateTime.now());
        tasks.addTask(task);
        task.setTitle("iets anders");
        tasks.editTaskByTaskDTO(task);


    }
}
