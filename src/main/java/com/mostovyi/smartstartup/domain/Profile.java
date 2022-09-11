package com.mostovyi.smartstartup.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Profile extends BaseSoftwareEntity {

    @OneToMany(mappedBy = "profile")
    private List<Program> programs;

}