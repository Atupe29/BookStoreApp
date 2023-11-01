package com.jdc04.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jdc04.Entity.MyBookList;
import com.jdc04.Repo.MybookRepo;

@Service
public class MybookListService {
	@Autowired
	private MybookRepo repo;

	public void saveMyBooks(MyBookList bookList) {
		repo.save(bookList);
	}
	 
}
