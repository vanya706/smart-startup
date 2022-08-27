package com.mostovyi.smartstartup.util;

import com.mostovyi.smartstartup.domain.BaseSoftwareEntity;
import javafx.util.StringConverter;

public class SoftwareConverter<T extends BaseSoftwareEntity> extends StringConverter<T> {


    @Override
    public String toString(T t) {
        return t.getName();
    }

    @Override
    public T fromString(String s) {
        // todo implement if needed
        return null;
    }

}
