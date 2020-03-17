package be.ucll.taskmanagermartijn.dto;

import be.ucll.taskmanagermartijn.domain.Subtask;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;

public class TaskDTO {
    private String title;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    private int id;
    private String dateTimeString;
    private ArrayList<Subtask> subtasks;

}
