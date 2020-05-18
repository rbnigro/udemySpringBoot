package com.ronneynigro.bookstoremanager.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ronneynigro.bookstoremanager.dto.BookDTO;
import com.ronneynigro.bookstoremanager.entity.Book;

@Mapper
public interface BookMapper {

	BookMapper INSTANCE = Mappers.getMapper(BookMapper.class);
	Book toModel(BookDTO bookDTO);
	BookDTO toDTO(Book book);
	
}
