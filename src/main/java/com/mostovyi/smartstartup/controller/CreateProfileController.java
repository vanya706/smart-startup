package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.service.ProfileService;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.CheckComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mostovyi.smartstartup.constant.FxmlView.MAIN;

@Component
@FxmlView
public class CreateProfileController extends BaseController {

    @FXML
    private TextField profileNameTextField;
    @FXML
    private CheckComboBox<Program> programsCheckComboBox;

    @Autowired
    private ProfileService profileService;

    @Override
    public void initialize() {

    }

    public void createProfile() {
        String name = profileNameTextField.getText();
        ObservableList<Program> checkedPrograms = programsCheckComboBox.getCheckModel().getCheckedItems();
        profileService.createProfile(name, checkedPrograms);
        stageManager.switchScene(MAIN);
    }

    public void cancel() {
        stageManager.switchScene(MAIN);
    }

}
