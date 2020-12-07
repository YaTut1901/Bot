package priv.dev.bot.service;

import priv.dev.bot.model.Status;

public interface UserService {
    Status getUserStatus(Integer chatId);
}
