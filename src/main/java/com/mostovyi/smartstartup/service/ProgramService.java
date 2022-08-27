package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.repository.ProgramRepository;
import javafx.scene.Node;
import javafx.scene.control.Label;
import org.controlsfx.control.ToggleSwitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Stream;

@Service
@Transactional
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

    public Node[] findAllProgramNodes() {
        return findAll()
                .stream()
                .flatMap(program -> {
                    ToggleSwitch isRun = new ToggleSwitch();
                    isRun.setSelected(program.isRun());
                    Label name = new Label();
                    name.setText(program.getName());
                    return Stream.of(name, isRun);
                })
                .toArray(Node[]::new);
    }

}
