package com.jdc04.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.jdc04.Entity.Book;
import com.jdc04.Entity.MyBookList;
import com.jdc04.service.BookService;
import com.jdc04.service.MybookListService;

@Controller
public class BookController {
	@Autowired
	private BookService service;
	@Autowired
	private MybookListService mybookService;

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("book_register")
	public String bookRegister() {
		return "bookRegister";
	}

	@GetMapping("/avialbe_book")
	public ModelAndView getAllBook() {
		List<Book> list = service.getAllBook();

		// ModelAndView m = new ModelAndView();
		// m.setViewName("bookList");
		// m.addObject("book", list);
		return new ModelAndView("bookList", "book", list);
	}

	@PostMapping("/save")
	public String addBook(@ModelAttribute Book book) {
		service.save(book);

		return "redirect:/avialbe_book";
	}

	@GetMapping("/my_Book")
	public String getMyBooks() {

		return "myBook";
	}

	@RequestMapping("/mylist/{id}")
	public String getMyList(@PathVariable("id") int id) {
		Book b = service.getBookId(id);
		MyBookList mb = new MyBookList(b.getId(), b.getName(), b.getAuthor(), b.getPrice());
		mybookService.saveMyBooks(mb);

		return "redirect:/my_Book";
	}
}
