package priv.dev.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.dev.bot.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
}
