package com.mostovyi.smartstartup.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Profile extends BaseSoftwareEntity {

    @ManyToMany(fetch = FetchType.EAGER)
    private List<Program> programs;

}