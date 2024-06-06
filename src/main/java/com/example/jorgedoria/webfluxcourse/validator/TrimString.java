package com.example.jorgedoria.webfluxcourse.validator;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Constraint(validatedBy = {TrimStringValidator.class}) // restrição de classe implementada
@Target(FIELD)
@Retention(RUNTIME)
public @interface TrimString {

    String message() default "O conteúdo não pode conter espaços em branco no início e no fim";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}