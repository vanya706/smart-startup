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
    requires spring.data.commons;
    requires spring.tx;
    requires spring.aop;
    requires org.hibernate.orm.core;
    requires org.apache.commons.collections4;
    requires org.apache.commons.lang3;
    requires org.slf4j;
    requires org.mapstruct;

    opens com.mostovyi.smartstartup;
    opens com.mostovyi.smartstartup.domain;
    opens com.mostovyi.smartstartup.controller to net.rgielen.fxweaver.core, javafx.fxml, spring.core;
    opens com.mostovyi.smartstartup.service to spring.core;
    opens com.mostovyi.smartstartup.config to spring.core;

    exports com.mostovyi.smartstartup to javafx.graphics;
    exports com.mostovyi.smartstartup.controller to spring.beans;
    exports com.mostovyi.smartstartup.service to spring.beans, spring.context;
    exports com.mostovyi.smartstartup.config to spring.beans, spring.context;
    exports com.mostovyi.smartstartup.mapper to spring.beans;
    exports com.mostovyi.smartstartup.util to spring.beans;
    opens com.mostovyi.smartstartup.model;
    exports com.mostovyi.smartstartup.mapper.base to spring.beans;
    exports com.mostovyi.smartstartup.util.component to spring.beans;
    exports com.mostovyi.smartstartup.util.converter to spring.beans;

}