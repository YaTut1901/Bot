package priv.dev.bot.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import priv.dev.bot.model.Student;
import priv.dev.bot.repository.StudentRepository;
import priv.dev.bot.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
    private StudentRepository repository;

    @Autowired
    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }

    @Override
    public Student save(Student student) {
        return repository.save(student);
    }

    @Override
    public Student getByTelegramChatId(Long chatId) {
        return repository.getByTelegramChatId(chatId).orElseThrow();
    }
}
