package com.ninja.lms.controller;

import com.ninja.lms.entity.LMSBatch;
import com.ninja.lms.jpa.LMSBatchRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class LMSBatchController {

    Logger logger = LoggerFactory.getLogger(LMSBatchController.class);

    @Autowired
    LMSBatchRepository lmsBatchRepository;

    // Get All Customers
    @GetMapping("/batches")
    List<LMSBatch> all() {
        logger.debug("Started get all batches..");
        return lmsBatchRepository.findAll();
    }

}
