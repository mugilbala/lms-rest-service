package com.ninja.lms.controller;

import com.ninja.lms.entity.LMSProgram;
import com.ninja.lms.jpa.LMSProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LMSProgramController {

    Logger logger = LoggerFactory.getLogger(LMSProgramController.class);

    @Autowired
    LMSProgramRepository lmsProgramRepository;

    // Get All Programs
    @GetMapping("/programs")
    List<LMSProgram> all() {
        logger.debug("Started get all programs..");
        return lmsProgramRepository.findAll();
    }

    @GetMapping("/programs/{programId}")
    LMSProgram getProgramById(@PathVariable("programId") Integer programId) {
        logger.debug("Get program by id..");
        return lmsProgramRepository.findByProgramId(programId);
    }

    @PostMapping("/programs")
    ResponseEntity<LMSProgram> createProgram(@Valid @RequestBody LMSProgram newProgram) {
        logger.debug("Create new program.");
//        return lmsProgramRepository.save(newProgram);
        return new ResponseEntity<>(newProgram, HttpStatus.OK);
    }


//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleValidationExceptions(MethodArgumentNotValidException ex) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(fieldName, errorMessage);
//        });
//        return errors;
//    }
}
