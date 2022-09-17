package com.mostovyi.smartstartup.util.component;

import com.mostovyi.smartstartup.model.BaseSoftwareModelInterface;
import com.mostovyi.smartstartup.util.converter.SoftwareModelCollectionConverter;
import com.mostovyi.smartstartup.util.converter.SoftwareModelConverter;
import javafx.collections.FXCollections;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;
import org.controlsfx.control.IndexedCheckModel;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class CheckComboBoxTableCell<S extends BaseSoftwareModelInterface, T extends BaseSoftwareModelInterface, C extends List<T>> extends TableCell<S, C> {

    private final Function<S, List<T>> itemsGetter;
    private final Consumer<S> onSaveConsumer;
    private final StringConverter<List<T>> itemsConverter;
    private final CheckComboBox<T> checkComboBox;

    public CheckComboBoxTableCell(List<T> items, Function<S, List<T>> itemsGetter, Consumer<S> onSaveConsumer) {
        this.itemsGetter = itemsGetter;
        this.onSaveConsumer = onSaveConsumer;
        this.itemsConverter = new SoftwareModelCollectionConverter<>();
        this.checkComboBox = new CheckComboBox<>(FXCollections.observableList(items));
        this.checkComboBox.setConverter(new SoftwareModelConverter<>());
    }

    public static <S extends BaseSoftwareModelInterface, T extends BaseSoftwareModelInterface> Callback<TableColumn<S, List<T>>, TableCell<S, List<T>>> forCellFactory(List<T> items, Function<S, List<T>> itemsGetter, Consumer<S> onSaveConsumer) {
        return callback -> new CheckComboBoxTableCell<>(items, itemsGetter, onSaveConsumer);
    }

    @Override
    public void startEdit() {
        super.startEdit();
        IndexedCheckModel<T> checkModel = checkComboBox.getCheckModel();
        S model = getCurrentTableViewItem();
        List<T> items = itemsGetter.apply(model);
        items.forEach(checkModel::check);
        setGraphic(checkComboBox);
    }

    @Override
    public void commitEdit(C newValue) {
        super.commitEdit(newValue);
        cancelEdit();
    }

    @Override
    public void cancelEdit() {
        super.cancelEdit();
        List<T> profiles = checkComboBox.getCheckModel().getCheckedItems();
        S model = getCurrentTableViewItem();
        List<T> items = itemsGetter.apply(model);
        items.clear();
        items.addAll(profiles);
        Label label = new Label();
        label.setText(itemsConverter.toString(profiles));
        setGraphic(label);
        onSaveConsumer.accept(model);
    }

    @Override
    protected void updateItem(C item, boolean empty) {
        super.updateItem(item, empty);
        if (item != null && !item.isEmpty()) {
            Label label = new Label();
            label.setText(itemsConverter.toString(item));
            setGraphic(label);
        } else {
            setGraphic(null);
        }
    }

    private S getCurrentTableViewItem() {
        int index = super.getTableRow().getIndex();
        return super.getTableView().getItems().get(index);
    }

}
