package com.example.demoDataMongo.validations;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TitleValidator implements ConstraintValidator<ValidTitle, String> {
    @Override
    public void initialize(ValidTitle constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value !=null && !value.isBlank()
                && !value.isEmpty() &&
                value.length() >10 && value.length() < 20;

    }
}
