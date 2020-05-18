package com.ronneynigro.bookstoremanager.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity 
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, unique = true)
	private String name;
	
	@Column(nullable = false)
	private Integer page;
	
	@Column(nullable = false)
	private Integer chapters;
	
	@Column(nullable = false)
	private String isbn;
	
	@Column(name = "publisher_name", nullable = false, unique = true)
	private String publisherName;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
	@JoinColumn(name = "author_id")
	private Author author;
	
	public Book(Long id, String name, Integer page, Integer chapters, String isbn, String publisherName,
			Author author) {
		super();
		this.id = id;
		this.name = name;
		this.page = page;
		this.chapters = chapters;
		this.isbn = isbn;
		this.publisherName = publisherName;
		this.author = author;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPage() {
		return page;
	}

	public void setPage(Integer page) {
		this.page = page;
	}

	public Integer getChapters() {
		return chapters;
	}

	public void setChapters(Integer chapters) {
		this.chapters = chapters;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getPublisherName() {
		return publisherName;
	}

	public void setPublisherName(String publisherName) {
		this.publisherName = publisherName;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public void author() {
		author.getName();
	}
}
