package com.mostovyi.smartstartup.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import org.controlsfx.control.ToggleSwitch;

public interface BaseSoftwareModelInterface {

    LongProperty id();

    StringProperty name();

    ObjectProperty<ToggleSwitch> run();

    default LongProperty idProperty() {
        return id();
    }

    default StringProperty nameProperty() {
        return name();
    }

    default ObjectProperty<ToggleSwitch> runProperty() {
        return run();
    }

}
