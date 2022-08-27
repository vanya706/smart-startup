package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Profile;
import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.repository.ProfileRepository;
import javafx.scene.Node;
import javafx.scene.control.Label;
import org.controlsfx.control.ToggleSwitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public void createProfile(String name, List<Program> programs) {
        Profile profile = new Profile();
        profile.setName(name);
        profile.setPrograms(programs);
        profileRepository.save(profile);
    }

    public List<Profile> findAll() {
        return profileRepository.findAll();
    }

    public Node[] findAllProfileNodes() {
        return findAll()
                .stream()
                .flatMap(profile -> {
                    ToggleSwitch isRun = new ToggleSwitch();
                    isRun.setSelected(profile.isRun());
                    Label name = new Label();
                    name.setText(profile.getName());
                    Label programs = new Label();
                    programs.setText(profile.getPrograms().stream().map(Program::getName).collect(Collectors.joining(", ")));
                    return Stream.of(isRun, name, programs);
                })
                .toArray(Node[]::new);
    }

}
