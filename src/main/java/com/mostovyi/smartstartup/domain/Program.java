package com.mostovyi.smartstartup.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Program extends BaseSoftwareEntity {

    @ManyToOne
    private Profile profile;

}
