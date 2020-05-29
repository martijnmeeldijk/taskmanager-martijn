package be.ucll.taskmanagermartijn.service;

import be.ucll.taskmanagermartijn.domain.Subtask;
import be.ucll.taskmanagermartijn.domain.Task;
import be.ucll.taskmanagermartijn.dto.SubtaskDTO;
import be.ucll.taskmanagermartijn.dto.TaskDTO;
import be.ucll.taskmanagermartijn.repo.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service("TaskServiceJPA")
public class TaskServiceJPA implements TaskService {

    private final TaskRepository repository;

    @Autowired
    public TaskServiceJPA(TaskRepository repository) {
        this.repository = repository;
    }
    @Override
    @Transactional
    public List<TaskDTO> getTasks() {
        return repository.findAll().stream().map(h -> {
            TaskDTO dto = new TaskDTO();
            dto.setId(h.getId());
            dto.setTitle(h.getTitle());
            dto.setDescription(h.getDescription());
            dto.setDateTime(h.getDateTime());

            dto.setSubtasks(h.getSubtasks()
                    .stream().map(s -> {
                        SubtaskDTO subtaskDTO = new SubtaskDTO();
                        subtaskDTO.setId(s.getId());
                        subtaskDTO.setTitle(s.getTitle());
                        subtaskDTO.setDescription(s.getDescription());

                        return subtaskDTO;
                    }).collect(Collectors.toList())
            );
            return dto;
        }).collect(Collectors.toList());
    }
    @Override
    @Transactional
    public void addTask(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDateTime(taskDTO.getDateTime());

        task.setSubtasks(taskDTO.getSubtasks()
                .stream().map(s -> {
                    Subtask subtask = new Subtask();
                    subtask.setId(s.getId());
                    subtask.setTitle(s.getTitle());
                    subtask.setDescription(s.getDescription());

                    return subtask;
                }).collect(Collectors.toList())
        );

        repository.save(task);

    }
    @Override
    @Transactional
    public TaskDTO getTaskDTOById(int id) {
        Task task = repository.getTaskById(id);
        TaskDTO dto = new TaskDTO();
        dto.setId(task.getId());
        dto.setTitle(task.getTitle());
        dto.setDescription(task.getDescription());
        dto.setDateTime(task.getDateTime());

        dto.setSubtasks(task.getSubtasks()
                .stream().map(s -> {
                    SubtaskDTO subtaskDTO = new SubtaskDTO();
                    subtaskDTO.setId(s.getId());
                    subtaskDTO.setTitle(s.getTitle());
                    subtaskDTO.setDescription(s.getDescription());

                    return subtaskDTO;
                }).collect(Collectors.toList())
        );

        return dto;
    }
    public Task getTaskById(int id) {

        return repository.getTaskById(id);
    }
    @Override
    @Transactional
    public void addTask(String title, String description, LocalDateTime dateTime) {
        Task task = new Task();
        task.setTitle(title);
        task.setDateTime(dateTime);
        task.setDescription(description);
        repository.save(task);
    }
    @Override
    @Transactional
    public void deleteTaskById(int id) {
        repository.deleteTaskById(id);
    }
    @Override
    @Transactional
    public void editTaskByTaskDTO(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        task.setDateTime(taskDTO.getDateTime());

        task.setSubtasks(taskDTO.getSubtasks()
                .stream().map(s -> {
                    Subtask subtask = new Subtask();
                    subtask.setId(s.getId());
                    subtask.setTitle(s.getTitle());
                    subtask.setDescription(s.getDescription());

                    return subtask;
                }).collect(Collectors.toList())
        );
        repository.save(task);
    }
    @Override
    @Transactional
    public void addSubtask(int mainTaskId, SubtaskDTO subtaskDTO) {
        Subtask subtask = new Subtask();
        subtask.setTitle(subtaskDTO.getTitle());
        subtask.setDescription(subtaskDTO.getDescription());

        Task task = getTaskById(mainTaskId);

        task.addSubtask(subtask);

        repository.save(task);
    }
    @Override
    public void deleteSubtask(int id, int subtaskId) {
        Task task = repository.getTaskById(id);
        task.deleteSubtask(subtaskId);
        repository.save(task);
    }
}
