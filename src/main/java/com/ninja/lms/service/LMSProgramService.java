package com.ninja.lms.service;

import com.ninja.lms.entity.LMSProgram;
import com.ninja.lms.jpa.LMSProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LMSProgramService {
    private static final Logger logger = LoggerFactory.getLogger(LMSProgramService.class);

    @Autowired
    LMSProgramRepository repository;

    public List<LMSProgram> findAll(){
        return repository.findAll();
    }

    public LMSProgram findByProgramId(Integer programId) {
        return repository.findByProgramId(programId);
    }

    public LMSProgram save(LMSProgram newProgram) {
        return repository.save(newProgram);
    }

}
