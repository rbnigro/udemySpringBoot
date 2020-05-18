package com.ronneynigro.bookstoremanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronneynigro.bookstoremanager.dto.MessageResponseDTO;
import com.ronneynigro.bookstoremanager.entity.Book;
import com.ronneynigro.bookstoremanager.repository.BookRepository;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	
	private BookRepository bookRepositiry;
	
	@Autowired
	public BookController(BookRepository bookRepository) {
		this.bookRepositiry = bookRepository;
	}
	
	@PostMapping
	public MessageResponseDTO create(@RequestBody Book book) {
		Book savedBook = bookRepositiry.save(book);
		MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
		messageResponseDTO.setMessage("Book criado. ID:[" + savedBook.getId() + "]");
		return messageResponseDTO;
	}
}
