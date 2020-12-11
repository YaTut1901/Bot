package priv.dev.bot.service;

import priv.dev.bot.model.Status;

import java.util.Optional;

public interface UserService {
    Optional<Status> getUserStatus(Long telegramChatId);
}
