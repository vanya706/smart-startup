package com.mostovyi.smartstartup.mapper.base;

import javafx.beans.property.*;
import org.apache.commons.lang3.BooleanUtils;

import java.util.List;

public interface BaseModelMapper {

    default LongProperty mapToLongProperty(Long aLong) {
        return new SimpleLongProperty(aLong);
    }

    default Long mapToLong(LongProperty longProperty) {
        return longProperty.get();
    }

    default StringProperty mapToStringProperty(String string) {
        return new SimpleStringProperty(string);
    }

    default String mapToString(StringProperty stringProperty) {
        return stringProperty.get();
    }

    default Boolean mapToBoolean(BooleanProperty booleanProperty) {
        return booleanProperty.get();
    }

    default BooleanProperty mapToBoolean(Boolean bool) {
        return new SimpleBooleanProperty(BooleanUtils.isTrue(bool));
    }

    default <T> SimpleListProperty<T> mapToSimpleListProperty(List<T> list) {
        SimpleListProperty<T> simpleListProperty = new SimpleListProperty<>();
        simpleListProperty.setAll(list);
        return simpleListProperty;
    }

    default <T> List<T> mapToList(SimpleListProperty<T> listProperty) {
        return listProperty.get();
    }

    default <T> ObjectProperty<T> mapToObjectProperty(T object) {
        return new SimpleObjectProperty<>(object);
    }

    default <T> T mapToObject(ObjectProperty<T> objectProperty) {
        return objectProperty.get();
    }

}
