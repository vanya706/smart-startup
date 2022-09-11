package com.mostovyi.smartstartup.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        FlowModel flowModel = (FlowModel) o;

        return new EqualsBuilder().append(id.get(), flowModel.id.get()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id.get()).toHashCode();
    }

}
