package priv.dev.bot.controllers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import priv.dev.bot.model.Status;

/**
 * Controller that insert all given information about a student
 */
@Component
public class StudentRegistrationMessageController extends MessageController {
    public static Status STATUS = Status.STUDENT_REGISTRATION;
    @Override
    public BotApiMethod getResponse(Update update) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setText("registration");
        sendMessage.setChatId(update.getMessage().getChatId());
        return sendMessage;
    }
}
