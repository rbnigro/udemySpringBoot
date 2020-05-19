package com.ronneynigro.bookstoremanager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ronneynigro.bookstoremanager.dto.MessageResponseDTO;
import com.ronneynigro.bookstoremanager.entity.Book;
import com.ronneynigro.bookstoremanager.mapper.BookMapper;
import com.ronneynigro.bookstoremanager.repository.BookRepository;

@Service
public class BookService {
	
	private BookRepository bookRepository;
	//private static final BookMapper bookMapper = BookMapper.INSTANCE;
	
	@Autowired
	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}
	
	public MessageResponseDTO create(Book book) {
		Book savedGBook = bookRepository.save(book);
		return MessageResponseDTO.builder()
			.message("Criado Book com id: [" + savedGBook.getId() + "]")
			.build();
		}		
//		Book bookToSave = bookMapper.toModel(bookDTO);
//		Book savedBook = bookRepository.save(bookToSave);

}
