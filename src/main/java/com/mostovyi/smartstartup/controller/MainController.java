package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.model.FlowModel;
import com.mostovyi.smartstartup.model.ProfileModel;
import com.mostovyi.smartstartup.model.ProgramModel;
import com.mostovyi.smartstartup.service.FlowService;
import com.mostovyi.smartstartup.service.ProfileService;
import com.mostovyi.smartstartup.service.ProgramService;
import com.mostovyi.smartstartup.util.CheckComboBoxTableCell;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.ToggleSwitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.mostovyi.smartstartup.constant.FxmlView.*;

@Component
@FxmlView
public class MainController extends BaseController {

    @FXML
    private TableView<FlowModel> flowsTableView;
    @FXML
    private TableView<ProfileModel> profilesTableView;
    @FXML
    private TableView<ProgramModel> programsTableView;

    @Autowired
    private FlowService flowService;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProgramService programService;

    @Override
    public void initialize() {
        initializeFlowTableView();
        initializeProfileTableView();
        initializeProgramTableView();
    }

    private void initializeFlowTableView() {
        List<FlowModel> flowModels = flowService.findAll();
        flowsTableView.setItems(FXCollections.observableList(flowModels));
        flowsTableView.setEditable(true);

        TableColumn<FlowModel, ToggleSwitch> runColumn = new TableColumn<>("Run");
        runColumn.setCellValueFactory(param -> {
            FlowModel flow = param.getValue();
            ToggleSwitch toggleSwitch = flow.run().get();
            toggleSwitch.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                if (toggleSwitch.isSelected()) {
                    flowService.run(flow.id().get());
                } else {
                    flowService.close(flow.id().get());
                }
            });
            return new SimpleObjectProperty<>(toggleSwitch);
        });

        TableColumn<FlowModel, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setEditable(true);
        nameColumn.setOnEditCommit(event -> {
            FlowModel flow = event.getRowValue();
            flow.name().set(event.getNewValue());
            flowService.save(flow);
        });

        List<ProfileModel> profiles = profileService.findAll();
        TableColumn<FlowModel, List<ProfileModel>> profilesColumn = new TableColumn<>("Profiles");
        profilesColumn.setEditable(true);
        profilesColumn.setCellValueFactory(new PropertyValueFactory<>("profiles"));
        profilesColumn.setCellFactory(CheckComboBoxTableCell.forCellFactory(profiles, FlowModel::profiles, flowModel -> flowService.save(flowModel)));

        flowsTableView.getColumns().setAll(runColumn, nameColumn, profilesColumn);
    }

    private void initializeProfileTableView() {
        List<ProfileModel> profileModels = profileService.findAll();
        profilesTableView.setItems(FXCollections.observableList(profileModels));
        profilesTableView.setEditable(true);

        TableColumn<ProfileModel, ToggleSwitch> runColumn = new TableColumn<>("Run");
        runColumn.setCellValueFactory(param -> {
            ProfileModel profile = param.getValue();
            ToggleSwitch toggleSwitch = profile.run().get();
            toggleSwitch.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                if (toggleSwitch.isSelected()) {
                    profileService.run(profile.id().get());
                } else {
                    profileService.close(profile.id().get());
                }
            });
            return new SimpleObjectProperty<>(toggleSwitch);
        });

        TableColumn<ProfileModel, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setEditable(true);
        nameColumn.setOnEditCommit(event -> {
            ProfileModel profileModel = event.getRowValue();
            profileModel.name().set(event.getNewValue());
            profileService.save(profileModel);
        });

        List<ProgramModel> programModels = programService.findAll();
        TableColumn<ProfileModel, List<ProgramModel>> programColumn = new TableColumn<>("Programs");
        programColumn.setEditable(true);
        programColumn.setCellValueFactory(new PropertyValueFactory<>("programs"));
        programColumn.setCellFactory(CheckComboBoxTableCell.forCellFactory(programModels, ProfileModel::programs, flowModel -> profileService.save(flowModel)));

        profilesTableView.getColumns().setAll(runColumn, nameColumn, programColumn);
    }

    private void initializeProgramTableView() {
        List<ProgramModel> programModels = programService.findAll();
        programsTableView.setItems(FXCollections.observableList(programModels));
        programsTableView.setEditable(true);

        TableColumn<ProgramModel, ToggleSwitch> runColumn = new TableColumn<>("Run");
        runColumn.setCellValueFactory(param -> {
            ProgramModel programModel = param.getValue();
            ToggleSwitch toggleSwitch = programModel.run().get();
            toggleSwitch.addEventHandler(MouseEvent.MOUSE_CLICKED, event -> {
                if (toggleSwitch.isSelected()) {
                    programService.run(programModel.id().get());
                } else {
                    programService.close(programModel.id().get());
                }
            });
            return new SimpleObjectProperty<>(toggleSwitch);
        });

        TableColumn<ProgramModel, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        nameColumn.setCellFactory(TextFieldTableCell.forTableColumn());
        nameColumn.setEditable(true);
        nameColumn.setOnEditCommit(event -> {
            ProgramModel programModel = event.getRowValue();
            programModel.name().set(event.getNewValue());
            programService.save(programModel);
        });

        programsTableView.getColumns().setAll(runColumn, nameColumn);
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
