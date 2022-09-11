package com.mostovyi.smartstartup.service;

import com.mostovyi.smartstartup.domain.Condition;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ConditionService {

    public boolean isReadyToRunByConditions(List<Condition> conditions) {

        Map<Long, List<Condition>> groupedConditionsMap = conditions.stream()
                .collect(Collectors.groupingBy(Condition::getGroupId));

        for (List<Condition> groupedConditions : groupedConditionsMap.values()) {
            if (isGroupedConditionsMatch(groupedConditions)) {
                return true;
            }
        }
        return false;
    }

    private boolean isGroupedConditionsMatch(List<Condition> conditions) {
        for (Condition condition : conditions) {
            if (!isConditionMatch(condition)) {
                return false;
            }
        }
        return true;
    }

    private boolean isConditionMatch(Condition condition) {
        return switch (condition.getType()) {
            case BUTTERY_STATE -> isButterStateMatch(condition);
            case DAY_OF_WEEK -> isDayOfWeekMatch(condition);
            case TIME -> isTimeMatch(condition);
        };
    }

    private boolean isButterStateMatch(Condition condition) {
        return switch (condition.getButteryState()) {
            case CHARGING -> isButteryCharging();
            case NOT_CHARGING -> !isButteryCharging();
        };
    }

    private boolean isButteryCharging() {
        // todo implement using JNA
        return true;
    }

    private boolean isDayOfWeekMatch(Condition condition) {
        return condition.getDaysOfWeek().contains(LocalDate.now().getDayOfWeek());
    }

    private boolean isTimeMatch(Condition condition) {
        return switch (condition.getTimeOperator()) {
            case BEFORE -> LocalTime.now().isBefore(condition.getTime());
            case AFTER -> LocalTime.now().isAfter(condition.getTime());
        };
    }

}
