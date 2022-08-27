package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.service.FlowService;
import com.mostovyi.smartstartup.service.ProfileService;
import com.mostovyi.smartstartup.service.ProgramService;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.layout.TilePane;
import net.rgielen.fxweaver.core.FxmlView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static com.mostovyi.smartstartup.constant.FxmlView.*;

@Component
@FxmlView
public class MainController extends BaseController {

    @FXML
    private TilePane flowsTilePane;
    @FXML
    private TilePane profilesTilePane;
    @FXML
    private TilePane programsTilePane;

    @Autowired
    private FlowService flowService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProgramService programService;

    @Override
    public void initialize() {
        Node[] flowNodes = flowService.findAllFlowNodes();
        flowsTilePane.getChildren().addAll(flowNodes);
        Node[] profileNodes = profileService.findAllProfileNodes();
        profilesTilePane.getChildren().addAll(profileNodes);
        Node[] programNodes = programService.findAllProgramNodes();
        programsTilePane.getChildren().addAll(programNodes);
    }

    public void createFlow() {
        stageManager.switchScene(CREATE_FLOW);
    }

    public void createProfile() {
        stageManager.switchScene(CREATE_PROFILE);
    }

    public void createProgram() {
        stageManager.switchScene(CREATE_PROGRAM);
    }

}
