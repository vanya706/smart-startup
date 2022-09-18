package com.mostovyi.smartstartup.repository;

import com.mostovyi.smartstartup.domain.Settings;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SettingsRepository extends JpaRepository<Settings, Long> {

}
