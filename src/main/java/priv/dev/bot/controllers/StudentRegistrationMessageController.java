package priv.dev.bot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import priv.dev.bot.exceptions.IllegalArgumentAmountException;
import priv.dev.bot.model.Status;
import priv.dev.bot.model.Student;
import priv.dev.bot.service.StudentService;
import priv.dev.bot.service.UserService;

import java.util.ArrayList;
import java.util.List;

/**
 * Controller that insert all given information about a student
 */
@Component
public class StudentRegistrationMessageController extends MessageController {
    public static Status STATUS = Status.STUDENT_REGISTRATION;
    private StudentService service;

    @Autowired
    public StudentRegistrationMessageController(StudentService service) {
        this.service = service;
    }

    @Override
    public BotApiMethod getResponse(Update update) {
        Long chatId = update.getMessage().getChatId();
        Student student = service.getByTelegramChatId(chatId);
        String[] data = null;
        try {
            data = parse(update.getMessage().getText());
        } catch (IllegalArgumentAmountException e) {
            return new SendMessage(chatId, "Введи имя и фамилию и ничего больше!");
        }
        student.setSurname(data[0]);
        student.setName(data[1]);
        student.setStatus(Status.STUDENT_MAIN_MENU);
        service.save(student);
        SendMessage message = new SendMessage(chatId, "Твои данные сохранены");
        return message;
    }

    private String[] parse(String text) throws IllegalArgumentAmountException {
        String[] data = text.split(" ");
        if (data.length != 2) {
            throw new IllegalArgumentAmountException("Wrong argument amount");
        }
        return data;
    }
}
