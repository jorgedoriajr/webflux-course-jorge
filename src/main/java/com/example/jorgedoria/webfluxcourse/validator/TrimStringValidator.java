package com.example.jorgedoria.webfluxcourse.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class TrimStringValidator implements ConstraintValidator<TrimString, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        // Se o valo é nulo OU se o tamanho da string sem espaços é igual ao tamanho original
        return value == null || value.trim().length() == value.length();
    }
}