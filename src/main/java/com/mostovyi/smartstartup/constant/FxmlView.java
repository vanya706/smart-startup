package com.mostovyi.smartstartup.constant;

import com.mostovyi.smartstartup.controller.*;
import lombok.Getter;

@Getter
public enum FxmlView {
    MAIN(MainController.class),
    CREATE_FLOW(CreateFlowController.class),
    CREATE_PROFILE(CreateProfileController.class),
    CREATE_PROGRAM(CreateProgramController.class);

    private final Class<? extends BaseController> controller;

    FxmlView(Class<? extends BaseController> controller) {
        this.controller = controller;
    }

}
