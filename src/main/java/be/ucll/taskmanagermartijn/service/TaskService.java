package be.ucll.taskmanagermartijn.service;

import be.ucll.taskmanagermartijn.domain.Subtask;
import be.ucll.taskmanagermartijn.domain.Task;
import be.ucll.taskmanagermartijn.dto.SubtaskDTO;
import be.ucll.taskmanagermartijn.dto.TaskDTO;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public interface TaskService {

    List<TaskDTO> getTasks();

    void addTask(TaskDTO task);

    public TaskDTO getTaskDTOById(int id);

    public Task getTaskById(int id);

    public void addTask(String title, String description, LocalDateTime dateTime);

    public void deleteTaskById(int id);



    public void addSubtask(int mainTaskId, SubtaskDTO subtaskDTO);

    public void editTaskByTaskDTO(TaskDTO taskDTO);

    void deleteSubtask(int id, int subtaskId);
}
