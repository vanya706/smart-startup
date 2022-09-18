package com.mostovyi.smartstartup.domain;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Settings extends BaseEntity {

    private Boolean useDarkTheme;

}
