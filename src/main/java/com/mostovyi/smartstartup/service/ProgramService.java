package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.repository.ProgramRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    public void create(String name) {
        Program program = new Program();
        program.setName(name);
        programRepository.save(program);
    }

    public List<Program> findAll() {
        return programRepository.findAll();
    }

}
