package priv.dev.bot.repository;

import org.jvnet.hk2.annotations.Service;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import priv.dev.bot.model.User;
import priv.dev.bot.model.Status;

@Service
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select u.status from User u where u.telegramChatId = :telegramChatId")
    Status getStatusByTelegramChatId(Integer telegramChatId);
}
