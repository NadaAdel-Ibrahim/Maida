package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.BorrowingRecord;
import com.example.demo.entity.Patron;
import com.example.demo.repository.BookRepository;
import com.example.demo.repository.BorrowingRecordRepository;
import com.example.demo.repository.PatronRepository;
import com.example.demo.service.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BorrowingRecordService {
	
	private BorrowingRecordRepository borrowingRecordRepository;
	private PatronRepository patronRepository;
	private BookRepository bookRepository;
	
	
	public BorrowingRecord borrowBook(Long bookId, Long patronId) {
		
        Book book = bookRepository.findById(bookId)
        		.orElseThrow(
        				() -> new ResourceNotFoundException("Book with" + bookId + "Not Found"));
        Patron patron = patronRepository.findById(patronId)
        		.orElseThrow(
        				() -> new ResourceNotFoundException("Patron with" + patronId + "Not Found"));
        
        BorrowingRecord borrowedReecord = new BorrowingRecord();
        borrowedReecord.setBook(book);
        borrowedReecord.setPatron(patron);
        borrowedReecord.setBorrowingDate(LocalDate.now());
        return borrowingRecordRepository.save(borrowedReecord);
    }
	
	
	public BorrowingRecord returnBook(Long bookId, Long patronId) {
		
		Book book = bookRepository.findById(bookId)
        		.orElseThrow(
        				() -> new ResourceNotFoundException("Book with" + bookId + "Not Found"));
        Patron patron = patronRepository.findById(patronId)
        		.orElseThrow(
        				() -> new ResourceNotFoundException("Patron with" + patronId + "Not Found"));
        
        BorrowingRecord record = borrowingRecordRepository.findByBookAndPatron(book, patron)
                .stream().filter(r -> r.getReturningDate() == null)
                .findFirst()
                .orElseThrow(() -> new RuntimeException("No borrowing record found"));
        record.setReturningDate(LocalDate.now());
        return borrowingRecordRepository.save(record);
	}
	
	

}
