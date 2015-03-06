package com.dao;

import java.util.List;

import com.domain.Book;

public interface IBookDAO {
	public Book create(Book b) throws Exception;
	public List<Book> findAll() throws Exception;
	
}
