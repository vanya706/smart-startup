package com.mostovyi.smartstartup.repository;

import com.mostovyi.smartstartup.domain.BaseSoftwareEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.util.List;
import java.util.UUID;

@NoRepositoryBean
public interface BaseSoftwareRepository<T extends BaseSoftwareEntity> extends JpaRepository<T, UUID> {

    List<T> findAllByRunFalse();

}
