module smart.startup {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;

    requires net.rgielen.fxweaver.core;

    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.core;
    requires spring.context;

    requires java.sql;

    opens com.mostovyi.smartstartup;
    opens com.mostovyi.smartstartup.controller to net.rgielen.fxweaver.core, javafx.fxml;

    exports com.mostovyi.smartstartup to javafx.graphics;
    exports com.mostovyi.smartstartup.controller to spring.beans;

}