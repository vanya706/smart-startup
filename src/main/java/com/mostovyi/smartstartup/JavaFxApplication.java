package com.mostovyi.smartstartup;

import com.mostovyi.smartstartup.constant.FxmlView;
import com.mostovyi.smartstartup.service.StageManager;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

public class JavaFxApplication extends Application {

    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(SmartStartupApplication.class)
                .run(args);
    }

    @Override
    public void start(Stage stage) {
        StageManager stageManager = applicationContext.getBean(StageManager.class, stage);
        stageManager.switchScene(FxmlView.MAIN);
        stage.show();
    }

    @Override
    public void stop() {
        applicationContext.close();
        Platform.exit();
    }

}
