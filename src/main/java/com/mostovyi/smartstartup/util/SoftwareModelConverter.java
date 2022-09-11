package com.mostovyi.smartstartup.util;

import com.mostovyi.smartstartup.model.BaseSoftwareModelInterface;
import javafx.util.StringConverter;

public class SoftwareModelConverter<T extends BaseSoftwareModelInterface> extends StringConverter<T> {


    @Override
    public String toString(T model) {
        return model.name().get();
    }

    @Override
    public T fromString(String s) {
        // todo implement if needed
        return null;
    }

}
