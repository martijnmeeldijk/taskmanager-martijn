package be.ucll.taskmanagermartijn.repo;

import be.ucll.taskmanagermartijn.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;


public interface TaskRepository extends JpaRepository<Task, Long> {


}
