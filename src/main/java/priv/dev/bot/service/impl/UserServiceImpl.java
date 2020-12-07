package priv.dev.bot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.dev.bot.model.Status;
import priv.dev.bot.repository.UserRepository;
import priv.dev.bot.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository repository;

    @Autowired
    public UserServiceImpl(UserRepository repository) {
        this.repository = repository;
    }

    public Status getUserStatus(Integer chatId) {
        return repository.getStatusByTelegramChatId(chatId);
    }
}
