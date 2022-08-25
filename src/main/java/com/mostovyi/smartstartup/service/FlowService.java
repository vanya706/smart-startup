package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Flow;
import com.mostovyi.smartstartup.repository.FlowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlowService {

    @Autowired
    private FlowRepository flowRepository;

    public List<Flow> findAllByRunFalse() {
        return flowRepository.findAllByRunFalse();
    }

    public void run(Flow flow) {
        // todo implement
    }

}
