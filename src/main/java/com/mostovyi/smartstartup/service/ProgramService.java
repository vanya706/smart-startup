package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.mapper.ProgramMapper;
import com.mostovyi.smartstartup.model.ProgramModel;
import com.mostovyi.smartstartup.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProgramService {

    @Autowired
    private ProgramMapper programMapper;
    @Autowired
    private ProgramRepository programRepository;

    public void create(String name, String path) {
        Program program = new Program();
        program.setName(name);
        program.setPath(path);
        programRepository.save(program);
    }

    public List<ProgramModel> findAll() {
        return programMapper.mapToModels(programRepository.findAll());
    }

    @Transactional
    public void save(ProgramModel programModel) {
        Long id = programModel.id().get();
        Program existent = programRepository.findById(id).get();
        programMapper.updateFromModel(existent, programModel);
        programRepository.save(existent);
    }

    public void run(long id) {

    }

    public void close(long id) {

    }

}
