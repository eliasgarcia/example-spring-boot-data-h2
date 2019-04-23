package com.example.abmBasico.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.abmBasico.domain.Book;
import com.example.abmBasico.repository.BookRepository;

@Component
public class BookService {
	@Autowired
    private BookRepository bookRepository;

    // You need to provide the constructor else Spring will have
    // no way to inject your dependency
    // BookRepository is an interface not a bean. So the actual
    // bean will be provided at runtime. See class for more documentation.
//    public BookService(BookRepository bookRepository) {
//        this.bookRepository = bookRepository;
//    }

    public List<Book> getAllBooks() {
        return (List<Book>) bookRepository.findAll();
    }
    
    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    
    public Long insertBook(Book book) {
    	book.setId(null);
    	return bookRepository.save(book).getId();
    }

	public Book save(Book book) {
		return bookRepository.save(book);
	}
}
