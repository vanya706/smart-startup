package com.mostovyi.smartstartup.constant;

import com.mostovyi.smartstartup.controller.CreateFlowController;
import com.mostovyi.smartstartup.controller.CreateProfileController;
import com.mostovyi.smartstartup.controller.CreateProgramController;
import com.mostovyi.smartstartup.controller.MainController;
import lombok.Getter;

@Getter
public enum FxmlView {
    MAIN(MainController.class),
    CREATE_FLOW(CreateFlowController.class),
    CREATE_PROFILE(CreateProfileController.class),
    CREATE_PROGRAM(CreateProgramController.class);

    private final Class<?> controller;

    FxmlView(Class<?> controller) {
        this.controller = controller;
    }

}
