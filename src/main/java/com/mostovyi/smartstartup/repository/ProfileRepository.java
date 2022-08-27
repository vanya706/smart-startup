package com.mostovyi.smartstartup.repository;

import com.mostovyi.smartstartup.domain.Profile;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProfileRepository extends JpaRepository<Profile, UUID> {

}
