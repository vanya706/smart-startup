package com.mostovyi.smartstartup.controller;

import javafx.fxml.FXML;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.stereotype.Component;

import static com.mostovyi.smartstartup.constant.FxmlView.CREATE_FLOW;

@Component
@FxmlView
public class MainController extends BaseController {

    @FXML
    private TilePane flowsTilePane;
    @FXML
    private VBox profilesVBox;
    @FXML
    private VBox programsVBox;

    public void createFlow() {
        stageManager.switchScene(CREATE_FLOW);
    }

}
