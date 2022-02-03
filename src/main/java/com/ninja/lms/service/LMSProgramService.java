package com.ninja.lms.service;

import com.ninja.lms.entity.LMSProgram;
import com.ninja.lms.exception.LMSException;
import com.ninja.lms.jpa.LMSProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class LMSProgramService {
    private static final Logger logger = LoggerFactory.getLogger(LMSProgramService.class);

    @Autowired
    LMSProgramRepository repository;

    public List<LMSProgram> findAll() {
        return repository.findAll();
    }

    public Optional<LMSProgram> findByProgramId(Integer programId) {
        return repository.findById(programId);
    }

    public LMSProgram save(LMSProgram newProgram) {
        if (repository.existsByProgramName(newProgram.getProgramName())) {
            throw new LMSException("LMS_1000", "Program name " + newProgram.getProgramName() + " already present.");
        }
        return repository.save(newProgram);
    }

    public LMSProgram update(Integer programId, LMSProgram updatedProgram) {
        LMSProgram program = repository.findById(programId).get();
        if (Objects.isNull(program)) {
            throw new LMSException("LMS_4000", "Program Id" + programId + " was not found.");
        }
        LMSProgram duplicateProgram = repository.findByProgramName(updatedProgram.getProgramName());
        if (Objects.nonNull(duplicateProgram) &&
                !duplicateProgram.getProgramId().equals(programId)) {
            throw new LMSException("LMS_1000", "Program name " + updatedProgram.getProgramName() + " already present.");
        }
        program.setProgramName(updatedProgram.getProgramName());
        program.setProgramStatus(updatedProgram.getProgramStatus());
        program.setProgramDescription(updatedProgram.getProgramDescription());

        return repository.save(program);
    }

    public void delete(Integer programId) {
        if (!repository.existsById(programId)) {
            throw new LMSException("LMS_4000", "Program Id " + programId + " was not found.");
        }
        // Program exists for given program Id
        repository.deleteById(programId);
    }

}
