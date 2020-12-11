package priv.dev.bot.controllers;

import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import priv.dev.bot.model.Status;

/**
 * Controller that return table with students of current teacher
 */
@Component
public class AllStudentsMessageController extends MessageController {
    public static Status STATUS = Status.FREE;
    @Override
    public BotApiMethod getResponse(Update update) {
        return new SendMessage();
    }
}
