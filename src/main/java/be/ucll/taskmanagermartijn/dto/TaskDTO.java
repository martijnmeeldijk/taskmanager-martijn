package be.ucll.taskmanagermartijn.dto;

import be.ucll.taskmanagermartijn.domain.Subtask;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import static com.sun.tools.javac.util.Constants.format;
/*
TODO
    Validation
    @Entity
    tags database : @Id, @GeneratedValue,
*/




public class TaskDTO {
    @Size(min=2, max=30)
    private String title;
    private String description;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;
    private int id;
    private String dateTimeString;
    private List<SubtaskDTO> subtasks;


    public TaskDTO() {
        subtasks = new ArrayList<>();
    }

    private boolean isValidDate(int day, int month, int year, int hour, int minute){
        return (day < 32 && day > 0 && month < 13 && month > 0 && hour >=0 && hour < 24 && minute >=0 && minute <61);
    }

    public String getTitle() {
        return title;
    }

    public String getDateTimeString() {
        return dateTimeString;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getDateTime(){
        return dateTime;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
        this.dateTimeString = DateTimeFormatter.ISO_DATE.format(dateTime) + " " + DateTimeFormatter.ISO_TIME.format(dateTime);
    }

    public void setId(int id) {
        this.id = id;
    }

    public void addSubtask(SubtaskDTO subtask){
        subtasks.add(subtask);
    }
    public void deleteSubtask(String subtask){
        SubtaskDTO subtask1 = null;
        for(SubtaskDTO s : subtasks){
            if(s.getTitle().equalsIgnoreCase(subtask)){
                subtask1 = s;

            }

        }
        subtasks.remove(subtask1);

    }
    public SubtaskDTO getSubtask(int id){
        for(SubtaskDTO s : subtasks){
            if(s.getId() == id){
                return s;
            }
        }
        return null;
    }


    public List<SubtaskDTO> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(List<SubtaskDTO> subtasks){
        this.subtasks = subtasks;
    }

}
