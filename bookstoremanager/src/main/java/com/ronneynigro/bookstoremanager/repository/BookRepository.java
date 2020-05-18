package com.ronneynigro.bookstoremanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ronneynigro.bookstoremanager.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
