package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.service.ProgramService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.ToggleSwitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Objects;

import static com.mostovyi.smartstartup.constant.FxmlView.MAIN;

@Component
@FxmlView
public class CreateProgramController extends BaseController {

    @FXML
    private TextField programNameTextField;
    @FXML
    private Label selectedProgramPathLabel;
    @FXML
    private Label selectedProgramName;
    @FXML
    private ToggleSwitch minimizedToggleSwitch;

    @Autowired
    private ProgramService programService;

    @Override
    public void initialize() {

    }

    public void createProgram() {
        String name = programNameTextField.getText();
        String path = selectedProgramPathLabel.getText();
        String fileName = selectedProgramName.getText();
        boolean minimized = minimizedToggleSwitch.isSelected();
        programService.create(name, path, fileName, minimized);
        stageManager.switchScene(MAIN);
    }

    public void chooseFile() {
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(selectedProgramPathLabel.getScene().getWindow());
        if (Objects.nonNull(file) && file.canExecute()) {
            selectedProgramPathLabel.setText(file.getPath());
            selectedProgramName.setText(file.getName());
        } else {
            selectedProgramPathLabel.setText("Selected not execute able file, please try another one.");
            selectedProgramName.setText("Selected not execute able file, please try another one.");
        }
    }

    public void cancel() {
        stageManager.switchScene(MAIN);
    }

}
