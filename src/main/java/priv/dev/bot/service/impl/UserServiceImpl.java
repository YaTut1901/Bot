package priv.dev.bot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.dev.bot.model.Status;
import priv.dev.bot.repository.StudentRepository;
import priv.dev.bot.repository.TeacherRepository;
import priv.dev.bot.repository.UserRepository;
import priv.dev.bot.service.UserService;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private TeacherRepository teacherRepository;
    private StudentRepository studentRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           TeacherRepository teacherRepository,
                           StudentRepository studentRepository) {
        this.userRepository = userRepository;
        this.teacherRepository = teacherRepository;
        this.studentRepository = studentRepository;
    }

    @Override
    public Optional<Status> getUserStatus(Long telegramChatId) {
        return userRepository.getStatusByTelegramChatId(telegramChatId);
    }
}
