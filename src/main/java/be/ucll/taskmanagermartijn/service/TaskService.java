package be.ucll.taskmanagermartijn.service;

import be.ucll.taskmanagermartijn.domain.Subtask;
import be.ucll.taskmanagermartijn.domain.Task;
import be.ucll.taskmanagermartijn.dto.TaskDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface TaskService {

    List<TaskDTO> getTasks();

    void addTask(TaskDTO task);

    public TaskDTO getTaskById(int id);

    public void addTask(String title, String description, LocalDateTime dateTime);

    public void deleteTaskById(int id);

    public void deleteTaskByTask(Task task);

    public void editTask(Task task);

    public void addSubtask(int mainTaskId, Subtask subtask);

}
