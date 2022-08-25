package com.mostovyi.smartstartup.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Flow extends BaseSoftwareEntity {

    @OneToMany(mappedBy = "flow")
    private List<Profile> profiles;

    @OneToMany(mappedBy = "flow")
    private List<Condition> conditions;

}
