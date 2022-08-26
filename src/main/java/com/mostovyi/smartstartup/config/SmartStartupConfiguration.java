package com.mostovyi.smartstartup.config;

import com.mostovyi.smartstartup.service.StageManager;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

@Configuration
public class SmartStartupConfiguration {

    @Autowired
    private FxWeaver fxWeaver;

    @Bean
    @Lazy
    public StageManager stageManager(Stage stage) {
        return new StageManager(fxWeaver, stage);
    }

}
