package priv.dev.bot.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import priv.dev.bot.Bot;
import priv.dev.bot.controllers.ResponseFormer;

@Configuration
public class BotConfig {
    private ResponseFormer former;

    @Autowired
    public BotConfig(ResponseFormer former) {
        this.former = former;
    }

    @Bean
    public Bot getBot() {
        Bot bot = new Bot();
        bot.setFormer(former);
        return bot;
    }
}
