package be.ucll.taskmanagermartijn.domain;

import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTests {

    @Test
    public void testEmptyTask(){
        Task task = new Task();
        assertNotNull(task);
        assertNotNull(task.getSubtasks());
        assertEquals(0, task.getSubtasks().size());
    }

    @Test
    public void testFullTask(){
        Task task = new Task();
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
    public void testSubtask(){
        Task task = new Task();
        task.setId(1);
        task.setTitle("title");
        task.setDescription("hallo");
        task.setDateTime(LocalDateTime.of(2020, 3, 12, 12, 12));

        Subtask subtask = new Subtask();
        subtask.setId(2);
        subtask.setDescription("yolo");
        subtask.setTitle("coole titel");

        task.addSubtask(subtask);

        assertEquals(subtask, task.getSubtask(2));
    }
}
