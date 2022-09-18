package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Profile;
import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.mapper.ProfileMapper;
import com.mostovyi.smartstartup.model.ProfileModel;
import com.mostovyi.smartstartup.repository.ProfileRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
public class ProfileService extends AbstractSoftwareService<ProfileModel> {

    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private ProfileRepository profileRepository;
    @Autowired
    private ProgramService programService;

    public void createProfile(String name, List<Program> programs) {
        Profile profile = new Profile();
        profile.setName(name);
        profile.setPrograms(programs);
        profileRepository.save(profile);
    }

    @Transactional
    public void save(ProfileModel profileModel) {
        Long id = profileModel.id().get();
        Profile existent = profileRepository.findById(id).get();
        profileMapper.updateFromModel(existent, profileModel);
        profileRepository.save(existent);
    }

    @Transactional
    public List<ProfileModel> findAll() {
        return profileMapper.mapToModels(profileRepository.findAll());
    }

    public void run(long id) {
        profileRepository.findById(id)
                .ifPresent(profile -> {
                    profile.getPrograms()
                            .stream()
                            .map(Program::getId)
                            .forEach(programService::run);
                    profile.setRun(true);
                    profileRepository.save(profile);
                });
    }

    public void close(long id) {
        profileRepository.findById(id)
                .ifPresent(profile -> {
                    profile.getPrograms()
                            .stream()
                            .map(Program::getId)
                            .forEach(programService::close);
                    profile.setRun(false);
                    profileRepository.save(profile);
                });
    }

}
