package priv.dev.bot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import priv.dev.bot.model.Status;
import priv.dev.bot.model.Student;
import priv.dev.bot.service.StudentService;

@Component
public class NewcomerMessageController extends MessageController {
    public static Status STATUS = Status.NEWCOMER_MESSAGE;
    private StudentService service;

    @Autowired
    public NewcomerMessageController(StudentService service) {
        this.service = service;
    }

    @Override
    public BotApiMethod getResponse(Update update) {
        Long chatId = update.getMessage().getChatId();
        SendMessage message = new SendMessage(chatId, "Привет, введи свои реальные имя и фамилию в формате \"Иванов Иван\"");
        Student student = service.getByTelegramChatId(chatId);
        student.setStatus(Status.STUDENT_REGISTRATION);
        service.save(student);
        return message;
    }
}
