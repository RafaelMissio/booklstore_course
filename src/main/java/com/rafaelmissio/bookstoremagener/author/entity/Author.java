package com.rafaelmissio.bookstoremagener.author.entity;

import com.rafaelmissio.bookstoremagener.entity.Auditable;
import com.rafaelmissio.bookstoremagener.books.entity.Book;
import jakarta.persistence.*;
import lombok.Data;


import java.io.Serial;
import java.io.Serializable;
import java.util.List;

@Data
@Entity
@Table(name = "db_author")
public class Author extends Auditable implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false,
            unique = true)
    private String name;

    @Column(columnDefinition = "integer default 0")
    private int age;

    @OneToMany(mappedBy = "author", fetch = FetchType.LAZY)
    private List<Book> books;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;
        return id == author.id;
    }

    @Override
    public int hashCode() {
        return Long.hashCode(id);
    }
}
