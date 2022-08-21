module smart.startup {

    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.controlsfx.controls;
    requires net.rgielen.fxweaver.core;
    requires spring.beans;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.core;
    requires spring.context;
    requires java.sql;
    requires lombok;
    requires jakarta.persistence;
    requires spring.data.jpa;
    requires org.hibernate.orm.core;

    opens com.mostovyi.smartstartup;
    opens com.mostovyi.smartstartup.domain;
    opens com.mostovyi.smartstartup.controller to net.rgielen.fxweaver.core, javafx.fxml, spring.core;
    opens com.mostovyi.smartstartup.service to spring.core;

    exports com.mostovyi.smartstartup to javafx.graphics;
    exports com.mostovyi.smartstartup.controller to spring.beans;
    exports com.mostovyi.smartstartup.service to spring.beans;

}