package com.example.jorgedoria.webfluxcourse.repository;

import com.example.jorgedoria.webfluxcourse.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class UserRepository {

    /*
        Não se utilizar o Extends como no JPA como no Spring Data.
     */
    private final ReactiveMongoTemplate mongoTemplate;

    public Mono<User> save(final User user) {
        return mongoTemplate.save(user);
    }

    public Mono<User> findById(String id) {
        return mongoTemplate.findById(id, User.class);
    }

}