package com.example.jorgedoria.webfluxcourse.controller;

import com.example.jorgedoria.webfluxcourse.model.request.UserRequest;
import com.example.jorgedoria.webfluxcourse.model.response.UserResponse;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface UserController {

    @PostMapping
    ResponseEntity<Mono<Void>> save(@Valid @RequestBody UserRequest request);

    /*
        Mono (quando queremos apenas um usuário ou nenhum usuário como resultado)
     */
    @GetMapping(value = "/{id}")
    ResponseEntity<Mono<UserResponse>> findById(@PathVariable String id);

    /*
        Flux (quando queremos vários usuários ou nenhum usuário como resultado por vez)
     */
    @GetMapping
    ResponseEntity<Flux<UserResponse>> findAll();

    @PatchMapping(value = "/{id}")
    ResponseEntity<Mono<UserResponse>> update(@PathVariable String id, @RequestBody UserRequest request);

    @DeleteMapping
    ResponseEntity<Mono<Void>> delete(@PathVariable String id);

}