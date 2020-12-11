package priv.dev.bot;

import lombok.Setter;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.generics.BotSession;
import org.telegram.telegrambots.starter.AfterBotRegistration;
import priv.dev.bot.controllers.ResponseFormer;

public class Bot extends TelegramLongPollingBot {
    @Setter
    private ResponseFormer former;

    @Override
    public void onUpdateReceived(Update update) {
        BotApiMethod response = former.form(update);
        try {
            execute(response);
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getBotUsername() {
        return "@eng_scheduler_bot";
    }

    @Override
    public String getBotToken() {
        return "1412175488:AAGBIH5nOclL1f1KrlJBfECrlZPPO20S7qk";
    }

    @AfterBotRegistration
    public void stopSession(BotSession session) {
        session.stop();
    }
}
