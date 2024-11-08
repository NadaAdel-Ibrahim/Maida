package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.repository.BookRepository;
import com.example.demo.service.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BookService {
	
	private BookRepository bookRepository;
	
	
	public List<Book>getAllBooks(){
		return bookRepository.findAll();
	}
	
	public Book getBookbyId(Long id) {
		return bookRepository.findById(id)
				.orElseThrow(
				() -> new ResourceNotFoundException("Book with" + id + "Not Found"));
			
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book deleteBook(Long id) {
		Book existBook = bookRepository.findById(id).get();
		bookRepository.deleteById(id);
		return existBook;
		
	}
	
	public Book updateBook(Long id , Book book) {	
			book.setId(id);
			return bookRepository.save(book);
	}
	

}
