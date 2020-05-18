package be.ucll.taskmanagermartijn.dto;

import be.ucll.taskmanagermartijn.domain.Subtask;
import be.ucll.taskmanagermartijn.domain.Task;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class TaskDTOTests {
    @Test
    public void testEmptyTaskDTO(){
        TaskDTO task = new TaskDTO();
        assertNotNull(task);
        assertNotNull(task.getSubtasks());
        assertEquals(0, task.getSubtasks().size());
    }
    @Test
    public void testFullTaskDTO(){
        TaskDTO task = new TaskDTO();
        task.setId(1);
        task.setTitle("title");
        task.setDescription("hallo");
        task.setDateTime(LocalDateTime.of(2020, 3, 12, 12, 12));

        assertNotNull(task);
        assertEquals("hallo", task.getDescription());
        assertEquals("title", task.getTitle());
        assertEquals(LocalDateTime.of(2020, 3, 12, 12, 12), task.getDateTime());
    }
    @Test
    public void testSubtaskDTO(){
        TaskDTO task = new TaskDTO();
        task.setId(1);
        task.setTitle("title");
        task.setDescription("hallo");
        task.setDateTime(LocalDateTime.of(2020, 3, 12, 12, 12));

        SubtaskDTO subtask = new SubtaskDTO();
        subtask.setId(2);
        subtask.setDescription("yolo");
        subtask.setTitle("coole titel");

        task.addSubtask(subtask);

        assertEquals(subtask, task.getSubtask(2));
    }
}
