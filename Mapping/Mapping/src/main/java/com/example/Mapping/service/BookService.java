package com.example.Mapping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mapping.model.Book;
import com.example.Mapping.repository.BookRepository;

@Service
public class BookService {
	
	@Autowired
	private BookRepository bookRepository;

	public List<Book> getAllBooks() {
		return bookRepository.findAll();
	}
	
	public Optional<Book> getBookById(String id) {
		return bookRepository.findById(id);
	}


	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	public Book updateBook(String id, Book book) {
	    Optional<Book> existingBook = bookRepository.findById(id);
	    if(existingBook.isPresent()) {
	      Book updateBook = existingBook.get();
	      updateBook.setAuthor(book.getAuthor());
	      updateBook.setDescription(book.getDescription());
	      updateBook.setPrice(book.getPrice());
	      updateBook.setTitle(book.getTitle());
	      updateBook.setStudent(book.getStudent());
	      return bookRepository.save(updateBook);
	    }else {
	    	throw new RuntimeException("student id not found"+id);
		}
	}

	public void deleteBook(String id) {
		bookRepository.deleteById(id);
	}

}
