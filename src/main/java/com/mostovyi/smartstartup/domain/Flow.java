package com.mostovyi.smartstartup.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Flow extends BaseSoftwareEntity {

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private List<Profile> profiles;

    @OneToMany(mappedBy = "flow")
    private List<Condition> conditions;

}
