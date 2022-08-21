package com.mostovyi.smartstartup.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;
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

    public void createFlow(ActionEvent actionEvent) {

        ToggleButton button = new ToggleButton();
        button.setText("click");
        Label name = new Label();
        name.setText("flow name");
        Label profile = new Label();
        profile.setText("profile name");
        Label condition = new Label();
        condition.setText("condition name");

        flowsTilePane.getChildren().addAll(button, name, profile, condition);
    }

}
