package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.domain.Profile;
import com.mostovyi.smartstartup.service.FlowService;
import com.mostovyi.smartstartup.service.ProfileService;
import com.mostovyi.smartstartup.util.SoftwareConverter;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.CheckComboBox;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.mostovyi.smartstartup.constant.FxmlView.MAIN;

@Component
@FxmlView
public class CreateFlowController extends BaseController {

    @FXML
    private TextField flowNameTextField;
    @FXML
    private CheckComboBox<Profile> profilesCheckComboBox;

    @Autowired
    private FlowService flowService;
    @Autowired
    private ProfileService profileService;

    @Override
    public void initialize() {
        List<Profile> profiles = profileService.findAll();
        profilesCheckComboBox.getItems().addAll(profiles);
        profilesCheckComboBox.setConverter(new SoftwareConverter<>());
    }

    public void createFlow() {
        String name = flowNameTextField.getText();
        ObservableList<Profile> checkedProfiles = profilesCheckComboBox.getCheckModel().getCheckedItems();
        flowService.createFlow(name, checkedProfiles);
        stageManager.switchScene(MAIN);
    }

    public void cancel() {
        stageManager.switchScene(MAIN);
    }

}
