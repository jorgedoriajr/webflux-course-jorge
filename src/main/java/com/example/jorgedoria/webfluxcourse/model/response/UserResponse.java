package com.example.jorgedoria.webfluxcourse.model.response;

public record UserResponse(
        String id,
        String name,
        String email,
        String password ) {
}