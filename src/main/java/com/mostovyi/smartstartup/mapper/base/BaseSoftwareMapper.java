package com.mostovyi.smartstartup.mapper.base;

import com.mostovyi.smartstartup.domain.BaseSoftwareEntity;
import org.apache.commons.lang3.BooleanUtils;
import org.controlsfx.control.ToggleSwitch;
import org.mapstruct.MappingTarget;

import java.util.List;

public interface BaseSoftwareMapper<E extends BaseSoftwareEntity, M> extends BaseModelMapper {

    List<M> mapToModels(List<E> entities);

    List<E> mapToEntities(List<M> models);

    E mapToEntities(M model);

    M mapToModels(E entity);

    void updateFromModel(@MappingTarget E existent, M model);

    default ToggleSwitch mapToToggleSwitch(Boolean value) {
        ToggleSwitch toggleSwitch = new ToggleSwitch();
        toggleSwitch.setSelected(BooleanUtils.isTrue(value));
        return toggleSwitch;
    }

    default ToggleSwitch mapToToggleSwitch(boolean value) {
        return mapToToggleSwitch((Boolean) value);
    }

    default boolean mapToBoolean(ToggleSwitch toggleSwitch) {
        return toggleSwitch.isSelected();
    }

}
