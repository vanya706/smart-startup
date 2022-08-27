package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Flow;
import com.mostovyi.smartstartup.domain.Profile;
import com.mostovyi.smartstartup.repository.FlowRepository;
import javafx.scene.Node;
import javafx.scene.control.Label;
import org.controlsfx.control.ToggleSwitch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Transactional
public class FlowService {

    @Autowired
    private FlowRepository flowRepository;
    @Lazy
    @Autowired
    private StageManager stageManager;

    public void createFlow(String name, List<Profile> checkedProfiles) {
        Flow flow = new Flow();
        flow.setName(name);
        flow.setProfiles(checkedProfiles);
        flowRepository.save(flow);
    }

    public void run(Flow flow) {
        // todo implement
    }

    public List<Flow> findAll() {
        return flowRepository.findAll();
    }

    public List<Flow> findAllByRunFalse() {
        return flowRepository.findAllByRunFalse();
    }

    public Node[] findAllFlowNodes() {
        return findAll()
                .stream()
                .flatMap(flow -> {
                    ToggleSwitch isRun = new ToggleSwitch();
                    isRun.setSelected(flow.isRun());
                    Label name = new Label();
                    name.setText(flow.getName());
                    Label profiles = new Label();
                    profiles.setText(flow.getProfiles().stream().map(Profile::getName).collect(Collectors.joining(", ")));
                    Label conditions = new Label();
                    conditions.setText("empty"); // todo implement toString for conditions
                    return Stream.of(isRun, name, profiles, conditions);
                })
                .toArray(Node[]::new);
    }

}
