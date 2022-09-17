package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.mapper.ProgramMapper;
import com.mostovyi.smartstartup.model.ProgramModel;
import com.mostovyi.smartstartup.repository.ProgramRepository;
import com.mostovyi.smartstartup.util.ProcessUtils;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class ProgramService extends AbstractSoftwareService {

    @Autowired
    private ProgramMapper programMapper;
    @Autowired
    private ProgramRepository programRepository;

    public void create(String name, String path, String fileName) {
        Program program = new Program();
        program.setName(name);
        program.setPath(path);
        program.setFileName(fileName);
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
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isEmpty()) {
            log.error("Program with id: {} does not exists!", id);
            return;
        }

        Program program = optionalProgram.get();
        if (program.isRun()) {
            log.info("Program with id: {} already run!", id);
            return;
        }

        ProcessUtils.runByPath(program.getPath());

        program.setRun(true);
        programRepository.save(program);
    }

    @SneakyThrows
    public void close(long id) {
        Optional<Program> optionalProgram = programRepository.findById(id);
        if (optionalProgram.isEmpty()) {
            log.error("Program with id: {} does not exists!", id);
            return;
        }

        Program program = optionalProgram.get();
        if (!program.isRun()) {
            log.info("Program with id: {} not running!", id);
            return;
        }

        ProcessUtils.destroyByFileName(program.getFileName());

        program.setRun(false);
        programRepository.save(program);
    }

}
