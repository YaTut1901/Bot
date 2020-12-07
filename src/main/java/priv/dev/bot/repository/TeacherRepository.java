package priv.dev.bot.repository;

import org.jvnet.hk2.annotations.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import priv.dev.bot.model.Teacher;

@Service
public interface TeacherRepository extends JpaRepository<Teacher, Long> {
}
