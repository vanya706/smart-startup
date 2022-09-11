package com.mostovyi.smartstartup.mapper;

import com.mostovyi.smartstartup.domain.Profile;
import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.mapper.base.BaseSoftwareMapper;
import com.mostovyi.smartstartup.model.ProfileModel;
import com.mostovyi.smartstartup.model.ProgramModel;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface ProfileMapper extends BaseSoftwareMapper<Profile, ProfileModel> {

    ProgramModel programToProgramModel(Program program);

    default SimpleListProperty<ProgramModel> programListToProgramModelSimpleListProperty(List<Program> list) {
        List<ProgramModel> programModels = list.stream().map(this::programToProgramModel).collect(Collectors.toList());
        return new SimpleListProperty<>(FXCollections.observableList(programModels));
    }

}
