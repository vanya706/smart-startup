package com.mostovyi.smartstartup.repository;

import com.mostovyi.smartstartup.domain.Program;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ProgramRepository extends JpaRepository<Program, UUID> {

}
