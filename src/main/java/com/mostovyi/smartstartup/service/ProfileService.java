package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Profile;
import com.mostovyi.smartstartup.domain.Program;
import com.mostovyi.smartstartup.mapper.ProfileMapper;
import com.mostovyi.smartstartup.model.ProfileModel;
import com.mostovyi.smartstartup.repository.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileMapper profileMapper;
    @Autowired
    private ProfileRepository profileRepository;

    public void createProfile(String name, List<Program> programs) {
        Profile profile = new Profile();
        profile.setName(name);
        profile.setPrograms(programs);
        profileRepository.save(profile);
    }

    @Transactional
    public List<ProfileModel> findAll() {
        return profileMapper.mapToModels(profileRepository.findAll());
    }

}
