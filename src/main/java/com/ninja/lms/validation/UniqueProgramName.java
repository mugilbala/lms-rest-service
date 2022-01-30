package com.ninja.lms.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UniqueProgramNameValidator.class)
@Documented
public @interface UniqueProgramName {
    String message() default "Program Name is already exists.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
