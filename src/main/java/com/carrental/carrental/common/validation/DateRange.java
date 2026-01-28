package com.carrental.carrental.common.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = DateRangeValidator.class)
@Target({ ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface DateRange {

    String message() default "End date must be after or equal to start date";

    String start();   // field name for start date
    String end();     // field name for end date

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}