package com.ninja.lms.controller;

import com.ninja.lms.dto.LMSBatchDTO;
import com.ninja.lms.entity.LMSBatch;
import com.ninja.lms.entity.LMSProgram;
import com.ninja.lms.jpa.LMSBatchRepository;
import com.ninja.lms.service.LMSBatchService;
import org.modelmapper.ModelMapper;
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
public class LMSBatchController {

    Logger logger = LoggerFactory.getLogger(LMSBatchController.class);

    @Autowired
    private LMSBatchService batchService;

    @Autowired
    LMSBatchRepository lmsBatchRepository;

    // Get All Batches
    @GetMapping("/batches")
    List<LMSBatch> all() {
        logger.debug("Started get all batches..");
        return batchService.getAllBatches();
    }

    // Get Batch by name and program id
    @GetMapping("/batches/{batchName}/{batchProgramId}")
    LMSBatch getBatchByNameAndProgramId(@PathVariable("batchName") String batchName, @PathVariable("batchProgramId") Integer batchProgramId) {
        logger.debug("Started get all batches by name and program id..");
        return batchService.getBatchByBatchNameAndProgramId(batchName, batchProgramId);
    }

    @PostMapping("/program/{batchProgramId}/batch")
        // Create New batch
    LMSBatch createCustomer(@PathVariable("batchProgramId") Integer batchProgramId, @Valid @RequestBody LMSBatch newBatch) {
        return batchService.createBatch(batchProgramId, newBatch);
    }


    // Get Batch by name and program id
    @PostMapping("/batches/create")
    LMSBatch getBatchById(@Valid @RequestBody LMSBatchDTO batchDTO) {
        return batchService.createBatchFromDTO(batchDTO);
    }


}
