package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Flow;
import com.mostovyi.smartstartup.domain.Profile;
import com.mostovyi.smartstartup.mapper.FlowMapper;
import com.mostovyi.smartstartup.mapper.ProfileMapper;
import com.mostovyi.smartstartup.model.FlowModel;
import com.mostovyi.smartstartup.model.ProfileModel;
import com.mostovyi.smartstartup.repository.FlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlowService extends AbstractSoftwareService<FlowModel> {

    @Autowired
    private FlowRepository flowRepository;
    @Autowired
    private ProfileService profileService;
    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private FlowMapper flowMapper;

    public void createFlow(String name, List<ProfileModel> checkedProfiles) {
        Flow flow = new Flow();
        flow.setName(name);
        flow.setProfiles(profileMapper.mapToEntities(checkedProfiles));
        flowRepository.save(flow);
    }

    public void save(FlowModel flowModel) {
        Long id = flowModel.id().get();
        Flow existent = flowRepository.findById(id).get();
        flowMapper.updateFromModel(existent, flowModel);
        flowRepository.save(existent);
    }

    public void run(Flow flow) {
        run(flow.getId());
    }

    public void run(long id) {
        flowRepository.findById(id)
                .ifPresent(flow -> {
                    flow.getProfiles()
                            .stream()
                            .map(Profile::getId)
                            .forEach(profileService::run);
                    flow.setRun(true);
                    flowRepository.save(flow);
                });
    }

    public void close(long id) {
        flowRepository.findById(id)
                .ifPresent(flow -> {
                    flow.getProfiles()
                            .stream()
                            .map(Profile::getId)
                            .forEach(profileService::close);
                    flow.setRun(false);
                    flowRepository.save(flow);
                });
    }

    @Transactional
    public List<FlowModel> findAll() {
        return flowMapper.mapToModels(flowRepository.findAll());
    }

    public List<Flow> findAllByRunFalse() {
        return flowRepository.findAllByRunFalse();
    }

}
