package com.mostovyi.smartstartup.domain;

import com.mostovyi.smartstartup.constant.ButteryState;
import com.mostovyi.smartstartup.constant.ConditionType;
import com.mostovyi.smartstartup.constant.TimeOperator;
import com.mostovyi.smartstartup.util.EnumConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Condition {

    @Id
    @GeneratedValue
    private Long id;

    private Long groupId;

    @Enumerated(EnumType.STRING)
    private ConditionType type;

    // buttery state
    @Enumerated(EnumType.STRING)
    private ButteryState butteryState;

    // day of week
    @Convert(converter = EnumConverter.class)
    private Set<DayOfWeek> daysOfWeek;

    // time
    @Enumerated(EnumType.STRING)
    private TimeOperator timeOperator;

    private LocalTime time;

    @ManyToOne
    private Flow flow;

}
