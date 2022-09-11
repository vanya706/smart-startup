package com.mostovyi.smartstartup.model;

import com.mostovyi.smartstartup.constant.ButteryState;
import com.mostovyi.smartstartup.constant.ConditionType;
import com.mostovyi.smartstartup.constant.TimeOperator;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

public record ConditionModel(Long id, Long groupId, ConditionType type, ButteryState butteryState,
                             Set<DayOfWeek> daysOfWeek, TimeOperator timeOperator, LocalTime time) {

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;

        if (o == null || getClass() != o.getClass()) return false;

        ConditionModel conditionModel = (ConditionModel) o;

        return new EqualsBuilder().append(id, conditionModel.id).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).toHashCode();
    }

}
