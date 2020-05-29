package be.ucll.taskmanagermartijn.service;

import be.ucll.taskmanagermartijn.domain.Task;
import be.ucll.taskmanagermartijn.dto.SubtaskDTO;
import be.ucll.taskmanagermartijn.dto.TaskDTO;
import org.aspectj.lang.annotation.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TaskServiceJPATests {
    @Qualifier("TaskServiceJPA")
    @Autowired
    TaskService tasks;



    @Test
    public void testJPA(){
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

        assertEquals(1, tasks.getTasks().size());
        assertNotNull(tasks.getTaskDTOById(1));
        tasks.addSubtask(task.getId(), subtask);
        tasks.deleteTaskById(task.getId());
        assertEquals(0, tasks.getTasks().size());
        tasks.addTask("azrfazef", "zafzae",LocalDateTime.now());
        tasks.addTask(task);
        task.setTitle("iets anders");
        tasks.editTaskByTaskDTO(task);

    }
}
