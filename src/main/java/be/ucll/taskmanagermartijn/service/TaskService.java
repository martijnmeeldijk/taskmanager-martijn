package be.ucll.taskmanagermartijn.service;

import be.ucll.taskmanagermartijn.domain.Subtask;
import be.ucll.taskmanagermartijn.domain.Task;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {
    List<Task> getTasks();

    void addTask(Task head);

    public Task getTaskById(int id);

    public void addTask(String title, String description, LocalDateTime dateTime);

    public void deleteTaskById(int id);

    public void deleteTaskByTask(Task task);

    public void editTask(Task task);

    public void addSubtask(int mainTaskId, Subtask subtask);

}
