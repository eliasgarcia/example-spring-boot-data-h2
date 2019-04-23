package com.example.abmBasico.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.abmBasico.domain.Book;
import com.example.abmBasico.service.BookService;

@RestController
public class BookController {

	@Autowired
	private BookService service;

	@GetMapping(value = "/book/1")
	@ResponseBody
	public ResponseEntity<Book> getBookTest() {
		return new ResponseEntity(new Book(1L, "libro", "autor"), HttpStatus.OK);
	}

	@GetMapping(value = "/book/{id}")
	@ResponseBody
	public ResponseEntity<Book> getBookById(@PathVariable("id") Long id) {
		Optional<Book> bookOp = service.getBookById(id);
		if (bookOp.isPresent()) {
			return new ResponseEntity(bookOp.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity("No se ha encontrado el libro.", HttpStatus.NOT_FOUND);
		}
	}

	@GetMapping(value = "/books")
	@ResponseBody
	public ResponseEntity<Book> getBooks() {
		return new ResponseEntity(service.getAllBooks(), HttpStatus.OK);
	}

	@PostMapping("/book")
	public ResponseEntity<Book> saveBook(@RequestBody Book book) {
		return new ResponseEntity(service.save(book),HttpStatus.CREATED);
	}

}
