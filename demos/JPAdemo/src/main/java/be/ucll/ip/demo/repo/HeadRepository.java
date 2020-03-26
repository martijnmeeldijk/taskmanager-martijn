package be.ucll.ip.demo.repo;

import be.ucll.ip.demo.domain.Head;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

public interface HeadRepository extends JpaRepository<Head, Long> {
}
