package com.example.jorgedoria.webfluxcourse.controller.exceptions;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.support.WebExchangeBindException;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(DuplicateKeyException.class)
    ResponseEntity<Mono<StandardError>> duplicateKeyException(DuplicateKeyException ex,
                                                              ServerHttpRequest request) {
        return ResponseEntity.badRequest()
                .body(Mono.just(
                        StandardError.builder()
                                .timestamp(LocalDateTime.now())
                                .path(request.getURI().getPath())
                                .status(BAD_REQUEST.value())
                                .error(BAD_REQUEST.getReasonPhrase())
                                .message(verifyDupKey(ex.getMessage()))
                                .build()
                ));
    }

    private String verifyDupKey(String message) {
        if (message.contains("email dup key")) {
            return "E-mail já cadastrado!";
        }
        return "Dup Key Exception";
    }

    @ExceptionHandler(WebExchangeBindException.class)
    public ResponseEntity<Mono<ValidationError>> validationError(WebExchangeBindException ex,
                                                                 ServerHttpRequest request) {
        ValidationError error = new ValidationError(
                LocalDateTime.now(),
                request.getPath().toString(),
                BAD_REQUEST.value(),
                "Erro de validação",
                "Erro na validação de atributos"
        );

        for (FieldError x : ex.getBindingResult().getFieldErrors()) {
            error.addError(x.getField(), x.getDefaultMessage());
        }

        return ResponseEntity.status(BAD_REQUEST).body(Mono.just(error));
    }

}