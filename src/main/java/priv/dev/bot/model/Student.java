package priv.dev.bot.model;

import ch.qos.logback.classic.util.StatusViaSLF4JLoggerFactory;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "students")
public class Student extends User {
    private String curTopic;
    private String engLevel;
    private LocalDateTime nextSession;
    @ManyToOne
    private Teacher teacher;

    public Student(String name,
                   String surname,
                   String curTopic,
                   String engLevel,
                   LocalDateTime nextSession,
                   Teacher teacher,
                   Status status, Integer telegramChatId) {
        super(name, surname, status, telegramChatId);
        this.curTopic = curTopic;
        this.engLevel = engLevel;
        this.nextSession = nextSession;
        this.teacher = teacher;
    }
}
