package com.mostovyi.smartstartup.controller;

import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import static com.mostovyi.smartstartup.constant.FxmlView.MAIN;

@Component
@FxmlView
public class CreateFlowController extends BaseController {

    public void createFlow() {

        // todo implement flow creation

        stageManager.switchScene(MAIN);
    }

}
