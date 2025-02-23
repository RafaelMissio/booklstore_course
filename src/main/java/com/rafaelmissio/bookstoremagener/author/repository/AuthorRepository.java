package com.rafaelmissio.bookstoremagener.author.repository;

import com.rafaelmissio.bookstoremagener.author.entity.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
}
