package com.mostovyi.smartstartup.domain;

import com.mostovyi.smartstartup.constant.ButteryState;
import com.mostovyi.smartstartup.constant.ConditionType;
import com.mostovyi.smartstartup.constant.TimeOperator;
import com.mostovyi.smartstartup.util.EnumConverter;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.UuidGenerator;

import java.time.DayOfWeek;
import java.time.LocalTime;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@Entity
public class Condition {

    @Id
    @GeneratedValue
    @UuidGenerator
    private UUID id;

    private UUID groupId;

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
