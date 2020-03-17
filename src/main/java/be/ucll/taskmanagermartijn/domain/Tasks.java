package be.ucll.taskmanagermartijn.domain;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Service
public class Tasks {
    Map<Integer, Task> tasks;

    public Tasks(){
        tasks = new HashMap<>();
        Task task1 = new Task(1, "Vechten op station tienen", "Geen religieuze bedoelingen", LocalDateTime.of(2020, 12, 23, 10,30));
        Task task2 = new Task(2, "Bidden tot Allah", "Lokaal C202", LocalDateTime.of(2020, 10, 13, 6,36));
        Task task3 = new Task(3, "Goede daden plegen", "(voor allah)", LocalDateTime.of(2020, 2, 3, 14,2));
        tasks.put(task1.getId(), task1);
        tasks.put(task2.getId(), task2);
        tasks.put(task3.getId(), task3);

    }

    public ArrayList<Task> getTasks() {

        return new ArrayList<>(tasks.values());
    }

    public Task get(int id) {

        return tasks.get(id);
    }

    public void addTask(Task task){
        task.setId(maxId() + 1);
        tasks.put(task.getId(), task);
    }

    public void addTask(String title, String description, LocalDateTime dateTime){
        int id = maxId() + 1;
        tasks.put(id, new Task(id, title, description, dateTime));
    }

    public void delete(int id) {
        tasks.remove(id);
    }
    public void delete(Task task){
        tasks.remove(task.getId());

    }
    public int maxId(){
        int max = 0;
        for(int key : tasks.keySet()){
            if(key > max) max = key;
        }
        return max;
    }

    public void edit(Task task) {
        delete(task.getId());
        tasks.put(task.getId(), task);


    }
    public void addSubtask(int mainTaskId, Subtask subtask){
        tasks.get(mainTaskId).addSubtask(subtask);
    }
}
