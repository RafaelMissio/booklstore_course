package com.rafaelmissio.bookstoremagener.author.mapper;

import com.rafaelmissio.bookstoremagener.author.dto.AuthorDTO;
import com.rafaelmissio.bookstoremagener.author.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper {

    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);

    Author toModel(AuthorDTO authorDTO);

    AuthorDTO toDTO(Author author);
}
