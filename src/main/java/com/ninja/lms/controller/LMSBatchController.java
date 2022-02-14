package com.ninja.lms.controller;

import com.ninja.lms.dto.LMSBatchDTO;
import com.ninja.lms.entity.LMSBatch;
import com.ninja.lms.service.LMSBatchService;
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

    @GetMapping("/health")
    String healthCheck(){
        return "up";
    }

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

    // Create New batch
    @PostMapping("/program/{batchProgramId}/batch")
    LMSBatch createBatch(@PathVariable("batchProgramId") Integer batchProgramId, @Valid @RequestBody LMSBatch newBatch) {
        return batchService.createBatch(batchProgramId, newBatch);
    }

    // Create new Batch with DTO
    @PostMapping("/batches/create")
    LMSBatch createBatchWithDto(@Valid @RequestBody LMSBatchDTO batchDTO) {
        return batchService.createBatchFromDTO(batchDTO);
    }


}
