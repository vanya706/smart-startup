package com.mostovyi.smartstartup.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.controlsfx.control.ToggleSwitch;

public record ProfileModel(LongProperty id, StringProperty name, ObjectProperty<ToggleSwitch> run,
                           SimpleListProperty<ProgramModel> programs) implements BaseSoftwareModelInterface {

    public SimpleListProperty<ProgramModel> programsProperty() {
        return programs;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProfileModel profileModel = (ProfileModel) o;

        return new EqualsBuilder().append(id.get(), profileModel.id.get()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id.get()).toHashCode();
    }

}
