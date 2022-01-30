package com.ninja.lms.validation;

import com.ninja.lms.jpa.LMSProgramRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueProgramNameValidator implements ConstraintValidator<UniqueProgramName, String> {
    private static final Logger logger = LoggerFactory.getLogger(UniqueProgramNameValidator.class);

    @Autowired
    private LMSProgramRepository lmsProgramRepository;

    @Override
    public void initialize(UniqueProgramName constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        logger.debug("isValid: value=[{}]", value);
        return !lmsProgramRepository.existsByProgramName(value);
    }
}
