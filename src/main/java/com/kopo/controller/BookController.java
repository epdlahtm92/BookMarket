package com.kopo.controller;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kopo.domain.Book;
import com.kopo.service.BookService;

@Controller
@RequestMapping("/books")
public class BookController {
	@Autowired
	private BookService bookService;
	
	//@RequestMapping
	//(value ="/books", method=RequestMethod.GET)
	@GetMapping
	public String requestBookList(Model model) {
		List<Book> list = bookService.getAllBookList();
		model.addAttribute("bookList", list);
		return "books";
	}
	
	/*
	 * @GetMapping("/all") public String requestBooks(Model model) { List<Book> list
	 * = bookService.getAllBookList(); model.addAttribute("bookList", list); return
	 * "books"; }
	 */
	
	@GetMapping("/all")
	public ModelAndView requestBooks() {
		ModelAndView modelAndView = new ModelAndView();
		List<Book> list = bookService.getAllBookList();
		modelAndView.addObject("bookList", list);
		
		modelAndView.setViewName("books");
		return modelAndView;
	}
	//controller/books/it
	@GetMapping("/{category}")
	public String requestBooksByCategory(@PathVariable("category") String bookCategory, Model model) {
		List<Book> booksByCategory = bookService.getBookListByCategory(bookCategory);
		model.addAttribute("bookList", booksByCategory);
		
		return "books";
	}

	@GetMapping("/filter/{bookFilter}")
	public String requestBooksByFilter(@MatrixVariable(pathVar="bookFilter") Map<String, List<String>> filter, Model model) {
		Set<Book> booksByFilter = bookService.getBookListByFilter(filter);
		model.addAttribute("bookList", booksByFilter);
		
		return "books";
	}
	
	@GetMapping("/book")
	public String requestBookById(@RequestParam("id") String bookId, Model model) {
		Book bookById = bookService.getBookId(bookId);
		model.addAttribute("book", bookById);
		return "book";
	}
	
	@GetMapping("/add")
	public String requestAddBookForm(@ModelAttribute("NewBook") Book book) {
		
		return "addBook";
	}
	
	@PostMapping("/add")
	public String submitAddNewBook(@ModelAttribute("NewBook") Book book) {
		bookService.setNewBook(book);
		return "redirect:/books";
	}
	
	@ModelAttribute
	public void addAttribute(Model model) {
		model.addAttribute("addTitle", "신규 도서 등록");
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.setAllowedFields(bookId, name, unitPrice, author, description, publisher, category, unitsInStock, releaseDate, condition, imgPath);
//		binder.setDisallowedFields("author");
	}
}