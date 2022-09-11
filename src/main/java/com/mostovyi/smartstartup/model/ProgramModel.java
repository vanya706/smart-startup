package com.mostovyi.smartstartup.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import org.controlsfx.control.ToggleSwitch;

public record ProgramModel(LongProperty id, StringProperty name,
                           ObjectProperty<ToggleSwitch> run) implements BaseSoftwareModelInterface {

}
