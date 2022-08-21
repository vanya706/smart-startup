package com.mostovyi.smartstartup;

import javafx.application.Application;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SmartStartupApplication {

    public static void main(String[] args) {
        Application.launch(JavaFxApplication.class, args);
    }

}
