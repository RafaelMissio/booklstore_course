package com.rafaelmissio.bookstoremagener.books.repository;

import com.rafaelmissio.bookstoremagener.books.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BooksRepository extends JpaRepository<Book,Long> {
}
