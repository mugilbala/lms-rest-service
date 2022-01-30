package com.ninja.lms.controller;

import com.ninja.lms.entity.LMSBatch;
import com.ninja.lms.jpa.LMSBatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/")
public class LMSBatchController {

    Logger logger = LoggerFactory.getLogger(LMSBatchController.class);

    @Autowired
    LMSBatchRepository lmsBatchRepository;

    // Get All Batches
    @GetMapping("/batches")
    List<LMSBatch> all() {
        logger.debug("Started get all batches..");
        return lmsBatchRepository.findAll();
    }

    // Get All Batches by name and program id
    @GetMapping("/batches/{batchName}/{batchProgramId}")
    List<LMSBatch> byNameAndProgramId(@PathVariable("batchName") String batchName, @PathVariable("batchProgramId") Integer batchProgramId) {
        logger.debug("Started get all batches by name and program id..");
        return lmsBatchRepository.findByBatchNameAndProgram_ProgramId(batchName, batchProgramId);
    }

    @PostMapping("/batch")
    // Create New Customer
    LMSBatch createCustomer(@RequestBody LMSBatch newBatch) {
        return lmsBatchRepository.save(newBatch);
    }

}
