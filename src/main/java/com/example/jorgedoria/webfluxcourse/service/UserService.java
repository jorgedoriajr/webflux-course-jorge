package com.example.jorgedoria.webfluxcourse.service;

import com.example.jorgedoria.webfluxcourse.entity.User;
import com.example.jorgedoria.webfluxcourse.mapper.UserMapper;
import com.example.jorgedoria.webfluxcourse.model.request.UserRequest;
import com.example.jorgedoria.webfluxcourse.repository.UserRepository;
import com.example.jorgedoria.webfluxcourse.service.exception.ObjectNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return userRepository.save(mapper.toEntity((request)));
    }

    public Mono<User> findById(final String id) {
        return userRepository.findById(id)
                .switchIfEmpty(Mono.error(
                        new ObjectNotFoundException(
                                format("Não encontrado! ID: %s - Type: %s", id, User.class.getSimpleName())
                        )
                ));
    }

}