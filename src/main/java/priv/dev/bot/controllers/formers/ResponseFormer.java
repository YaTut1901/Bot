package priv.dev.bot.controllers.formers;

import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.meta.api.methods.BotApiMethod;
import org.telegram.telegrambots.meta.api.objects.Update;
import priv.dev.bot.controllers.MessageController;
import priv.dev.bot.model.Status;
import priv.dev.bot.model.Student;
import priv.dev.bot.service.StudentService;
import priv.dev.bot.service.UserService;
import priv.dev.bot.utils.ControllerStorage;
import java.util.Optional;

@Component
public class ResponseFormer {
    private ControllerStorage storage;
    private ApplicationContext context;
    private UserService userService;
    private StudentService studentService;

    public ResponseFormer(ControllerStorage storage,
                          ApplicationContext context,
                          UserService userService,
                          StudentService studentService) {
        this.storage = storage;
        this.context = context;
        this.userService = userService;
        this.studentService = studentService;
    }

    public BotApiMethod form(Update update) {
        Long chatId = update.getMessage().getChatId();
        Optional<Status> optionalStatus = userService.getUserStatus(chatId);
        Status status;
        if (optionalStatus.isEmpty()) {
            Student student = new Student();
            student.setTelegramChatId(chatId);
            student.setStatus(Status.NEWCOMER_MESSAGE);
            studentService.save(student);
            status = Status.NEWCOMER_MESSAGE;
        } else {
            status = optionalStatus.get();
        }
        MessageController controller = (MessageController) context.getBean(storage.getController(status));
        return controller.getResponse(update);
    }
}
