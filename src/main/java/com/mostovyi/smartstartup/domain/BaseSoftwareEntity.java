package com.mostovyi.smartstartup.domain;

import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseSoftwareEntity extends BaseEntity {

    private String name;

    private boolean run;

}
