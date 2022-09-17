package com.mostovyi.smartstartup.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Program extends BaseSoftwareEntity {

    private String path;

    private String fileName;

}
