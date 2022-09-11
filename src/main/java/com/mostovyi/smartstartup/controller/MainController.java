package com.mostovyi.smartstartup.controller;

import com.mostovyi.smartstartup.model.FlowModel;
import com.mostovyi.smartstartup.model.ProfileModel;
import com.mostovyi.smartstartup.model.ProgramModel;
import com.mostovyi.smartstartup.service.FlowService;
import com.mostovyi.smartstartup.service.ProfileService;
import com.mostovyi.smartstartup.service.ProgramService;
import com.mostovyi.smartstartup.util.SoftwareModelCollectionConverter;
import com.mostovyi.smartstartup.util.SoftwareModelConverter;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import net.rgielen.fxweaver.core.FxmlView;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.IndexedCheckModel;
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

        List<FlowModel> flows = flowService.findAll();
        flowsTableView.setItems(FXCollections.observableList(flows));
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
        profilesColumn.setCellFactory(callback -> new TableCell<>() {

            @Override
            public void startEdit() {
                super.startEdit();
                FlowModel flowModel = getCurrentFlow();

                CheckComboBox<ProfileModel> checkComboBox = new CheckComboBox<>(FXCollections.observableList(profiles));
                checkComboBox.setConverter(new SoftwareModelConverter<>());
                IndexedCheckModel<ProfileModel> checkModel = checkComboBox.getCheckModel();
                flowModel.profiles().forEach(checkModel::check);
                setGraphic(checkComboBox);
            }

            @Override
            public void commitEdit(List<ProfileModel> newValue) {
                super.commitEdit(newValue);
                cancelEdit();
            }

            @Override
            public void cancelEdit() {
                super.cancelEdit();
                CheckComboBox<ProfileModel> checkComboBox = (CheckComboBox<ProfileModel>) getGraphic();
                List<ProfileModel> profiles = checkComboBox.getCheckModel().getCheckedItems();
                FlowModel flowModel = getCurrentFlow();
                flowModel.profiles().clear();
                flowModel.profiles().addAll(profiles);
                Label label = new Label();
                label.setText(new SoftwareModelCollectionConverter<>().toString(flowModel.profiles()));
                setGraphic(label);
                flowService.save(flowModel);
            }

            @Override
            protected void updateItem(List<ProfileModel> item, boolean empty) {
                super.updateItem(item, empty);
                if (item != null && !item.isEmpty()) {
                    Label label = new Label();
                    label.setText(new SoftwareModelCollectionConverter<>().toString(item));
                    setGraphic(label);
                } else {
                    setGraphic(null);
                }
            }

            private FlowModel getCurrentFlow() {
                int index = super.getTableRow().getIndex();
                return super.getTableView().getItems().get(index);
            }
        });

        flowsTableView.getColumns().setAll(runColumn, nameColumn, profilesColumn);

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
