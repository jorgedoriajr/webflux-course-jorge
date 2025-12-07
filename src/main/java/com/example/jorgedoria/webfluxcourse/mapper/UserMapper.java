package com.example.jorgedoria.webfluxcourse.mapper;

import com.example.jorgedoria.webfluxcourse.entity.User;
import com.example.jorgedoria.webfluxcourse.model.request.UserRequest;
import com.example.jorgedoria.webfluxcourse.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import static org.mapstruct.NullValueCheckStrategy.ALWAYS;
import static org.mapstruct.NullValuePropertyMappingStrategy.IGNORE;

@Mapper(componentModel = "spring",
        nullValuePropertyMappingStrategy = IGNORE, //Quando o valor das propriedades forem nulas, ignorar
        nullValueCheckStrategy = ALWAYS) //Sempre chevar valore Nulos
public interface UserMapper {

    /*
        A Anotação @Mapping ignora o mapeamento do ID para inclusão, pois o mongoDB gera o ID automaticamente.
     */
    @Mapping(target = "id", ignore = true)
    User toEntity(final UserRequest request);

    UserResponse toResponse(final User entity);

}