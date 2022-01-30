package com.ninja.lms.jpa;

import com.ninja.lms.entity.LMSProgram;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LMSProgramRepository extends JpaRepository<LMSProgram, Integer> {
    LMSProgram findByProgramName(String programName);

    LMSProgram findByProgramId(Integer programId);

    boolean existsByProgramName(String programName);
}
