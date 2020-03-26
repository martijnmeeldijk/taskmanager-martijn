package be.ucll.taskmanagermartijn.service;

import be.ucll.taskmanagermartijn.domain.Subtask;
import be.ucll.taskmanagermartijn.domain.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class TaskServiceLocal implements TaskService{
    Map<Integer, Task> tasks;

    public TaskServiceLocal(){
        tasks = new HashMap<>();
        Task task1 = new Task();
        Task task2 = new Task();
        Task task3 = new Task();
        task1.setId(1);
        task1.setTitle("Vechten op station tienen");
        task1.setDescription("Geen religieuze bedoelingen");
        task1.setDateTime(LocalDateTime.of(2020, 12, 23, 10,30));

        task2.setId(2);
        task2.setTitle("Bidden tot Allah");
        task2.setDescription("Lokaal C202");
        task2.setDateTime(LocalDateTime.of(2020, 10, 13, 6,36));

        task3.setId(3);
        task3.setTitle("Goede daden plegen");
        task3.setDescription("(voor allah)");
        task3.setDateTime(LocalDateTime.of(2020, 2, 3, 14,2));

        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
        tasks.put(task3.getId(), task3);

    }

    public ArrayList<Task> getTasks() {

        return new ArrayList<>(tasks.values());
    }

    public Task getTaskById(int id) {

        return tasks.get(id);
    }

    public void addTask(Task task){
        task.setId(maxId() + 1);
        tasks.put(task.getId(), task);
    }

    public void addTask(String title, String description, LocalDateTime dateTime){
        int id = maxId() + 1;
        Task task = new Task();
        task.setId(id);
        task.setDateTime(dateTime);
        task.setTitle(title);
        task.setDescription(description);
        tasks.put(id, task);
    }

    public void deleteTaskById(int id) {
        tasks.remove(id);
    }

    public void deleteTaskByTask(Task task){
        tasks.remove(task.getId());

    }
    public int maxId(){
        int max = 0;
        for(int key : tasks.keySet()){
            if(key > max) max = key;
        }
        return max;
    }

    public void editTask(Task task) {
        deleteTaskById(task.getId());
        tasks.put(task.getId(), task);


    }
    public void addSubtask(int mainTaskId, Subtask subtask){
        tasks.get(mainTaskId).addSubtask(subtask);
    }
}
