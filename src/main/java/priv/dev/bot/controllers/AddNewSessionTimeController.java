package priv.dev.bot.controllers;

import org.telegram.telegrambots.meta.api.objects.Update;

/**
 * Controller that allows teacher to add time of the next session to student's profile
 */
public class AddNewSessionTimeController extends Controller {
    public static String TAG = "add";
    @Override
    public String getResponse(Update update) {
        return "null";
    }
}
