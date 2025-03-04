package com.rafaelmissio.bookstoremagener.publishers.repository;

import com.rafaelmissio.bookstoremagener.publishers.entity.Publisher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PublisherRepository extends JpaRepository<Publisher,Long> {
}
