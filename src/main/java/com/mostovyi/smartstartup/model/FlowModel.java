package com.mostovyi.smartstartup.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import org.controlsfx.control.ToggleSwitch;

public record FlowModel(LongProperty id, StringProperty name, ObjectProperty<ToggleSwitch> run,
                        SimpleListProperty<ProfileModel> profiles,
                        SimpleListProperty<ConditionModel> conditions) implements BaseSoftwareModelInterface {

    public SimpleListProperty<ProfileModel> profilesProperty() {
        return profiles;
    }

    public SimpleListProperty<ConditionModel> conditionsProperty() {
        return conditions;
    }

}
