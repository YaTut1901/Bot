package priv.dev.bot.controllers;

import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Every controller should be extended from Controller abstract class and has
 * constant field TAG with tag that invoke this controller
 */
public abstract class MessageController {
    public abstract BotApiMethod getResponse(Update update);
}
