package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.service.MainService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.ToggleSwitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@FxmlView
public class MainController {

    @FXML
    private TilePane flowsTilePane;
    @FXML
    private VBox profilesVBox;
    @FXML
    private VBox programsVBox;

    @Autowired
    private MainService mainService;

    public void createFlow(ActionEvent actionEvent) {
        ToggleSwitch toggleSwitch = new ToggleSwitch();
        Label name = new Label();
        name.setText("flow name");
        Label profile = new Label();
        profile.setText("profile name");
        Label condition = new Label();
        condition.setText("condition name");

        mainService.createFlow();

        flowsTilePane.getChildren().addAll(toggleSwitch, name, profile, condition);
    }

}
