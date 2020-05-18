package com.ronneynigro.bookstoremanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronneynigro.bookstoremanager.dto.BookDTO;
import com.ronneynigro.bookstoremanager.dto.MessageResponseDTO;
import com.ronneynigro.bookstoremanager.entity.Book;
import com.ronneynigro.bookstoremanager.mapper.BookMapper;
import com.ronneynigro.bookstoremanager.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepositiry;
	private final BookMapper bookMapper = BookMapper.INSTANCE;
	
	@Autowired
	public BookService(BookRepository bookRepositiry) {
		this.bookRepositiry = bookRepositiry;
	}
	
	public MessageResponseDTO create(BookDTO bookDTO) {
		Book bookToSave = bookMapper.toModel(bookDTO);
		
		Book savedBook = bookRepositiry.save(bookToSave);
		MessageResponseDTO messageResponseDTO = new MessageResponseDTO();
		messageResponseDTO.setMessage("Book criado. ID:[" + savedBook.getId() + "]");
		return messageResponseDTO;
	}

}
