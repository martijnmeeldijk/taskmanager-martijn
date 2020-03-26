package be.ucll.taskmanagermartijn.dto;

import org.springframework.stereotype.Service;

import javax.persistence.ManyToOne;
import javax.validation.constraints.Size;

public class SubtaskDTO {

    @Size(min=2, max=30)
    private String title;
    private String description;
    private int id;








    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
