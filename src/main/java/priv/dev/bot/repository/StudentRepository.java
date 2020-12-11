package priv.dev.bot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import priv.dev.bot.model.Student;
import priv.dev.bot.model.Teacher;

import java.util.Optional;

public interface StudentRepository extends JpaRepository<Student, Long> {
    Optional<Student> getByTelegramChatId(Long telegramChatId);
}
