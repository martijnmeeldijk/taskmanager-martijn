package be.ucll.ip.demo.model.repo;

import be.ucll.ip.demo.model.entity.Head;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HeadRepository extends JpaRepository<Head, Long> {
}
