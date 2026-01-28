package com.carrental.carrental.common.validation;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.lang.reflect.Field;
import java.time.LocalDate;

public class DateRangeValidator implements ConstraintValidator<DateRange, Object> {

    private String startFieldName;
    private String endFieldName;

    @Override
    public void initialize(DateRange constraintAnnotation) {
        this.startFieldName = constraintAnnotation.start();
        this.endFieldName = constraintAnnotation.end();
    }

    @Override
    public boolean isValid(Object value, ConstraintValidatorContext context) {
        if (value == null) {
            return true;
        }

        try {
            Field startField = value.getClass().getDeclaredField(startFieldName);
            Field endField = value.getClass().getDeclaredField(endFieldName);

            startField.setAccessible(true);
            endField.setAccessible(true);

            Object startObj = startField.get(value);
            Object endObj = endField.get(value);

            // Let @NotNull handle missing values
            if (startObj == null || endObj == null) {
                return true;
            }

            // Only validate if both are LocalDate
            if (!(startObj instanceof LocalDate) || !(endObj instanceof LocalDate)) {
                return true;
            }

            LocalDate start = (LocalDate) startObj;
            LocalDate end = (LocalDate) endObj;

            boolean valid = !end.isBefore(start);

            // If invalid, attach message to the "end" field (better for frontend forms)
            if (!valid) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                        .addPropertyNode(endFieldName)
                        .addConstraintViolation();
            }

            return valid;

        } catch (NoSuchFieldException | IllegalAccessException e) {
            // If reflection fails, don't block requests (safe fallback)
            return true;
        }
    }
}