package com.mostovyi.smartstartup.util.component;

import com.mostovyi.smartstartup.model.BaseSoftwareModelInterface;
import com.mostovyi.smartstartup.service.AbstractSoftwareService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import org.controlsfx.control.ToggleSwitch;

public class SellValueToggleSwitch<S extends BaseSoftwareModelInterface> extends SimpleObjectProperty<ToggleSwitch> {

    private final AbstractSoftwareService service;
    private final S softwareModel;

    public SellValueToggleSwitch(AbstractSoftwareService service, S softwareModel) {
        super(softwareModel.run().get());
        this.service = service;
        this.softwareModel = softwareModel;
        registerSelectedListener();
    }

    public static <S extends BaseSoftwareModelInterface> Callback<TableColumn.CellDataFeatures<S, ToggleSwitch>, ObservableValue<ToggleSwitch>> forCellValueFactory(AbstractSoftwareService service) {
        return callback -> new SellValueToggleSwitch<>(service, callback.getValue());
    }

    private void registerSelectedListener() {
        ToggleSwitch toggleSwitch = this.getValue();
        toggleSwitch.addEventHandler(MouseEvent.MOUSE_RELEASED, event -> {
            if (toggleSwitch.isSelected()) {
                service.run(softwareModel.id().get());
            } else {
                service.close(softwareModel.id().get());
            }
        });
    }

}
