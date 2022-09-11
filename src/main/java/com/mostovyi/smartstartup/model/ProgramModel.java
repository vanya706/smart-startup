package com.mostovyi.smartstartup.model;

import javafx.beans.property.LongProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.StringProperty;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.controlsfx.control.ToggleSwitch;

public record ProgramModel(LongProperty id, StringProperty name, ObjectProperty<ToggleSwitch> run,
                           StringProperty path) implements BaseSoftwareModelInterface {

    public StringProperty pathProperty() {
        return path;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ProgramModel programModel = (ProgramModel) o;

        return new EqualsBuilder().append(id.get(), programModel.id.get()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id.get()).toHashCode();
    }

}
