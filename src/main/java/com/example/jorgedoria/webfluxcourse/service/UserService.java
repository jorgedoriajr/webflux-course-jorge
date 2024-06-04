package com.example.jorgedoria.webfluxcourse.service;

import com.example.jorgedoria.webfluxcourse.entity.User;
import com.example.jorgedoria.webfluxcourse.mapper.UserMapper;
import com.example.jorgedoria.webfluxcourse.model.request.UserRequest;
import com.example.jorgedoria.webfluxcourse.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper mapper;

    public Mono<User> save(final UserRequest request) {
        return userRepository.save(mapper.toEntity((request)));
    }

}