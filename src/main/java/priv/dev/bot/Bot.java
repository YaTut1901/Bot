package priv.dev.bot;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;
import priv.dev.bot.controllers.Controller;
import priv.dev.bot.utils.ControllerStorage;


public class Bot extends TelegramLongPollingBot {

    public Bot() {
        ControllerStorage.init();
    }

    @Override
    public void onUpdateReceived(Update update) {
//        Controller controller = ControllerStorage.getController(update.getMessage().getChatId())
    }

    @Override
    public String getBotUsername() {
        return "@eng_scheduler_bot";
    }

    @Override
    public String getBotToken() {
        return "1412175488:AAGBIH5nOclL1f1KrlJBfECrlZPPO20S7qk";
    }
}
