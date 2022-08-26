package com.mostovyi.smartstartup.constant;

import com.mostovyi.smartstartup.controller.CreateFlowController;
import com.mostovyi.smartstartup.controller.MainController;
import lombok.Getter;

@Getter
public enum FxmlView {
    MAIN(MainController.class),
    CREATE_FLOW(CreateFlowController.class);

    private final Class<?> controller;

    FxmlView(Class<?> controller) {
        this.controller = controller;
    }

}
