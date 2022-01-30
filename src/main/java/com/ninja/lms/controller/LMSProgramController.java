package com.ninja.lms.controller;

import com.ninja.lms.entity.LMSProgram;
import com.ninja.lms.service.LMSProgramService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
@Validated
public class LMSProgramController {

    Logger logger = LoggerFactory.getLogger(LMSProgramController.class);

    @Autowired
    LMSProgramService service;

    // Get All Programs
    @GetMapping("/programs")
    List<LMSProgram> all() {
        logger.debug("Started get all programs..");
        return service.findAll();
    }

    @GetMapping("/programs/{programId}")
    LMSProgram getProgramById(@PathVariable("programId") Integer programId) {
        logger.debug("Get program by id..");
        return service.findByProgramId(programId);
    }

    @PostMapping("/programs")
    LMSProgram createProgram(@Valid @RequestBody LMSProgram newProgram) {
        logger.debug("Create new program.");
        return service.save(newProgram);
    }

}
