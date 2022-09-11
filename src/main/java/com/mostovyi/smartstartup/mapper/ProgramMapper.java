package com.mostovyi.smartstartup.mapper;

import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.mapper.base.BaseSoftwareMapper;
import com.mostovyi.smartstartup.model.ProgramModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProgramMapper extends BaseSoftwareMapper<Program, ProgramModel> {

}
