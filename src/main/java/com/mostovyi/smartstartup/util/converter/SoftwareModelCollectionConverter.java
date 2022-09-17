package com.mostovyi.smartstartup.util.converter;

import com.mostovyi.smartstartup.model.BaseSoftwareModelInterface;
import javafx.beans.property.StringProperty;
import javafx.util.StringConverter;

import java.util.Collection;
import java.util.stream.Collectors;

public class SoftwareModelCollectionConverter<T extends Collection<? extends BaseSoftwareModelInterface>> extends StringConverter<T> {

    @Override
    public String toString(T softwareModels) {
        return softwareModels.stream()
                .map(BaseSoftwareModelInterface::name)
                .map(StringProperty::get)
                .collect(Collectors.joining(", "));
    }

    @Override
    public T fromString(String string) {
        return null;
    }

}
