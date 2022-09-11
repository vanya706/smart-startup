package com.mostovyi.smartstartup.model;

import com.mostovyi.smartstartup.constant.ButteryState;
import com.mostovyi.smartstartup.constant.ConditionType;
import com.mostovyi.smartstartup.constant.TimeOperator;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

public record ConditionModel(Long id, Long groupId, ConditionType type, ButteryState butteryState,
                             Set<DayOfWeek> daysOfWeek, TimeOperator timeOperator, LocalTime time) {

}
