package com.mostovyi.smartstartup.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import org.controlsfx.control.ToggleSwitch;

public record ProfileModel(LongProperty id, StringProperty name, ObjectProperty<ToggleSwitch> run,
                           SimpleListProperty<ProgramModel> programs) implements BaseSoftwareModelInterface {

    public SimpleListProperty<ProgramModel> programsProperty() {
        return programs;
    }

}
