package priv.dev.bot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "teachers")
public class Teacher extends User {
    @OneToMany
    private List<Student> students;

    public Teacher(String name, String surname, Status status, Long telegramChatId) {
        super(name, surname, status, telegramChatId);
        students = new ArrayList<>();
    }
}
