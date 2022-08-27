package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.service.ProgramService;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mostovyi.smartstartup.constant.FxmlView.MAIN;

@Component
@FxmlView
public class CreateProgramController extends BaseController {

    @FXML
    private TextField programNameTextField;

    @Autowired
    private ProgramService programService;

    @Override
    public void initialize() {

    }

    public void createProgram() {
        String name = programNameTextField.getText();
        programService.create(name);
        stageManager.switchScene(MAIN);
    }

    public void cancel() {
        stageManager.switchScene(MAIN);
    }

}
