package com.mostovyi.smartstartup.util.component;

import com.mostovyi.smartstartup.model.BaseSoftwareModelInterface;
import com.mostovyi.smartstartup.model.ProgramModel;
import com.mostovyi.smartstartup.service.AbstractSoftwareService;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import org.controlsfx.control.ToggleSwitch;

import java.util.function.Supplier;

public class SellValueToggleSwitch extends SimpleObjectProperty<ToggleSwitch> {

    public SellValueToggleSwitch(Supplier<ToggleSwitch> supplier, ChangeListener<Boolean> changeListener) {
        super(supplier.get());
        supplier.get()
                .selectedProperty()
                .addListener(changeListener);
    }

    public static <S extends BaseSoftwareModelInterface> Callback<TableColumn.CellDataFeatures<S, ToggleSwitch>, ObservableValue<ToggleSwitch>> forRunCellValueFactory(AbstractSoftwareService<S> service) {
        return callback -> new SellValueToggleSwitch(() -> callback.getValue().run().get(), (observable, oldValue, newValue) -> {
            if (newValue) {
                service.run(callback.getValue().id().get());
                return;
            }
            service.close(callback.getValue().id().get());
        });
    }

    public static <S extends ProgramModel> Callback<TableColumn.CellDataFeatures<S, ToggleSwitch>, ObservableValue<ToggleSwitch>> forMinimizedCellValueFactory(AbstractSoftwareService<S> service) {
        return callback -> new SellValueToggleSwitch(() -> callback.getValue().minimized().get(), (observable, oldValue, newValue) -> {
            service.save(callback.getValue());
        });
    }

}
