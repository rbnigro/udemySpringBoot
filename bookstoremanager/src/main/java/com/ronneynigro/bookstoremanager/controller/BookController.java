package com.ronneynigro.bookstoremanager.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ronneynigro.bookstoremanager.dto.BookDTO;
import com.ronneynigro.bookstoremanager.dto.MessageResponseDTO;
import com.ronneynigro.bookstoremanager.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookController {
	 
	private BookService bookService;
	
	@Autowired
	public BookController(BookService bookService) {
		this.bookService = bookService; 
	}
	
	@PostMapping
	public MessageResponseDTO create(@RequestBody @Valid BookDTO bookDTO) {
		//return bookService.create(bookDTO);
		return MessageResponseDTO.builder()
				.message("Book criado com o id: [" + bookDTO.getId() + "]")
				.build();
	}
}
