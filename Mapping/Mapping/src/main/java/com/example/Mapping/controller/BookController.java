package com.example.Mapping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Mapping.model.Book;
import com.example.Mapping.service.BookService;

@RestController
@RequestMapping("/books")
public class BookController {
  
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getAllBooks(){
		return bookService.getAllBooks();
	}
	
	@GetMapping("/{Id}")
	public ResponseEntity<Book> getBookById(@PathVariable String Id) {
		Optional<Book> book = bookService.getBookById(Id);
		if (book.isPresent()) {
			return new ResponseEntity<>(book.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(book.get(), HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping
	public ResponseEntity<Book> createBook(@RequestBody Book book) {
		Book createdBook = bookService.createBook(book);
		return new ResponseEntity<>(createdBook,HttpStatus.CREATED);
	}

	@PutMapping("/{Id}")
	public ResponseEntity<Book> updateBook(@PathVariable String Id, @RequestBody Book book) {
		Book updatedBook = bookService.updateBook(Id, book);
		return new ResponseEntity<>(updatedBook,HttpStatus.OK);
	}
	
	@DeleteMapping("/{studentId}")
	public ResponseEntity<Void> deleteBook(@PathVariable String Id) {
		bookService.deleteBook(Id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
}
