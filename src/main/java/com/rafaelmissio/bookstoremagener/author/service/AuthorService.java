package com.rafaelmissio.bookstoremagener.author.service;

import com.rafaelmissio.bookstoremagener.author.mapper.AuthorMapper;
import com.rafaelmissio.bookstoremagener.author.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorService {

    private final static AuthorMapper authorMapper = AuthorMapper.INSTANCE;

    private AuthorRepository authorRepository;

    @Autowired
    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }
}
