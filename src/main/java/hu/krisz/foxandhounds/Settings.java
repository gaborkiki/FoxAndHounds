package hu.krisz.foxandhounds;

import hu.krisz.foxandhounds.model.GState;
import hu.krisz.foxandhounds.model.MapVO;
import hu.krisz.foxandhounds.service.command.GameCommands;
import hu.krisz.foxandhounds.service.command.Step;
import hu.krisz.foxandhounds.service.map.MapBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Settings {
    @Bean
    public GState GameState() {
        return new GState(null, false, true, null, null);
    }

    @Bean
    public MapVO MapVO() {
        return new MapVO(0, null);
    }

    @Bean
    public GameCommands GameCommands() {
        return new GameCommands("", null);
    }

    @Bean
    public Step StepCommand() {
        return new Step(null, "", "");
    }

    @Bean
    public MapBuilder MapBuilder() {
        return new MapBuilder(0);
    }


}
