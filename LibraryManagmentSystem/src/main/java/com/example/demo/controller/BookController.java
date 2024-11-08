package com.example.demo.controller;

import java.util.List;

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

import com.example.demo.entity.Book;
import com.example.demo.service.BookService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/books")
public class BookController {
	
	 private BookService bookService;

	    @GetMapping("/books")
	    public ResponseEntity<List<Book>> getAllBooks() {
	        return ResponseEntity
	        		.ok (bookService.getAllBooks());
	    }

	    @GetMapping("/book/{id}")
	    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
	        return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(bookService.getBookbyId(id));
	    }
	    

	    @PostMapping("/books")
	    public ResponseEntity<Book> addBook(@RequestBody Book book) {
	        return  ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(bookService.addBook(book));
	    }
	    

	    @PutMapping("/{id}")
	    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
	        return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(bookService.updateBook(id, book));
	    }
	    

	    @DeleteMapping("/book/{id}")
	    public ResponseEntity<Book> deleteBook(@PathVariable Long id) {
	        return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(bookService.deleteBook(id));
	    }

}
