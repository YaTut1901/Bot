package priv.dev.bot.model;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long telegramChatId;
    private String name;
    private String surname;
    @Enumerated(EnumType.STRING)
    private Status status;

    public User(String name, String surname, Status status, Long telegramChatId) {
        this.name = name;
        this.surname = surname;
        this.status = status;
        this.telegramChatId = telegramChatId;
    }
}
