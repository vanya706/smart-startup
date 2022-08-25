package com.mostovyi.smartstartup.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@Transactional
@RequiredArgsConstructor
public class ScheduledService {

    private final ConditionService conditionService;

    private final FlowService flowService;

    @Scheduled(fixedDelay = 1, timeUnit = TimeUnit.MINUTES)
    public void runFlows() {
        flowService.findAllByRunFalse()
                .stream()
                .filter(flow -> conditionService.isReadyToRunByConditions(flow.getConditions()))
                .forEach(flowService::run);
    }

}
