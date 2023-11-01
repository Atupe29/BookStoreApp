package com.jdc04.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc04.Entity.Book;
import com.jdc04.Entity.MyBookList;
import com.jdc04.Repo.BookRepo;

@Service
public class BookService {
@Autowired
private BookRepo repo;
	public void save(Book book) {
	repo.save(book);	
	}
	public List<Book>getAllBook(){
		return repo.findAll();
				
	}
	public Book getBookId(int id) {
		return repo.findById(id).get();
	}
}
