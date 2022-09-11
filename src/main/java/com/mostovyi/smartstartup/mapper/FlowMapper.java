package com.mostovyi.smartstartup.mapper;

import com.mostovyi.smartstartup.domain.Condition;
import com.mostovyi.smartstartup.domain.Flow;
import com.mostovyi.smartstartup.domain.Profile;
import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.mapper.base.BaseSoftwareMapper;
import com.mostovyi.smartstartup.model.ConditionModel;
import com.mostovyi.smartstartup.model.FlowModel;
import com.mostovyi.smartstartup.model.ProfileModel;
import com.mostovyi.smartstartup.model.ProgramModel;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface FlowMapper extends BaseSoftwareMapper<Flow, FlowModel> {

    ConditionModel conditionToConditionModel(Condition condition);

    ProfileModel profileToProfileModel(Profile profile);

    ProgramModel programToProgramModel(Program program);

    default SimpleListProperty<ConditionModel> conditionListToConditionModelSimpleListProperty(List<Condition> list) {
        List<ConditionModel> conditionModels = list.stream().map(this::conditionToConditionModel).collect(Collectors.toList());
        return new SimpleListProperty<>(FXCollections.observableList(conditionModels));
    }

    default SimpleListProperty<ProfileModel> profileListToProfileModelSimpleListProperty(List<Profile> list) {
        List<ProfileModel> profileModels = list.stream().map(this::profileToProfileModel).collect(Collectors.toList());
        return new SimpleListProperty<>(FXCollections.observableList(profileModels));
    }

    default SimpleListProperty<ProgramModel> programListToProgramModelSimpleListProperty(List<Program> list) {
        List<ProgramModel> programModels = list.stream().map(this::programToProgramModel).collect(Collectors.toList());
        return new SimpleListProperty<>(FXCollections.observableList(programModels));
    }

}
