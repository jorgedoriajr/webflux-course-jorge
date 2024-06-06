package com.example.jorgedoria.webfluxcourse.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record UserRequest(

        @NotBlank(message = "Não pode ser nulo ou vazio")
        @Size(min=3, max=50, message = "Deve ser entre 3 e 50 caracteres")
        String name,

        @Email(message = "E-mail inválido!")
        @NotBlank(message = "Não pode ser nulo ou vazio")
        String email,

        @NotBlank(message = "Não pode ser nulo ou vazio")
        @Size(min=3, max=20, message = "Deve ser entre 3 e 20 caracteres")
        String password) {

}