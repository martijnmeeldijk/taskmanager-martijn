package be.ucll.taskmanagermartijn.domain;

import org.springframework.stereotype.Service;

import javax.validation.constraints.Size;

@Service
public class Subtask {

    @Size(min=2, max=30)
    private String title;
    private String description;

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
}
