package com.ninja.lms.jpa;

import com.ninja.lms.entity.LMSProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LMSProgramRepository extends JpaRepository<LMSProgram, Long> {
}
