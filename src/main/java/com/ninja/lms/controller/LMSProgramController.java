package com.ninja.lms.controller;

import com.ninja.lms.entity.LMSBatch;
import com.ninja.lms.entity.LMSProgram;
import com.ninja.lms.jpa.LMSBatchRepository;
import com.ninja.lms.jpa.LMSProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class LMSProgramController {

    Logger logger = LoggerFactory.getLogger(LMSProgramController.class);

    @Autowired
    LMSProgramRepository lmsProgramRepository;

    // Get All Customers
    @GetMapping("/programs")
    List<LMSProgram> all() {
        logger.debug("Started get all programs..");
        return lmsProgramRepository.findAll();
    }

}
