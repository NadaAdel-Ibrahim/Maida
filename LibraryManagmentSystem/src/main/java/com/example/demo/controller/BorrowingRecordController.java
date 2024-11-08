package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.demo.entity.BorrowingRecord;
import com.example.demo.service.BorrowingRecordService;

public class BorrowingRecordController {
	
	 private BorrowingRecordService borrowingRecordService;
	 
	 @PostMapping("/borrow/{bookId}/patron/{patronId}")
	 public ResponseEntity<BorrowingRecord> borrowBook(@PathVariable Long bookId, @PathVariable Long patronId) {
	      return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(borrowingRecordService.borrowBook(bookId, patronId));
	 }
	 
	 @PutMapping("/return/{bookId}/patron/{patronId}")
	 public ResponseEntity<BorrowingRecord> returnBook(@PathVariable Long bookId, @PathVariable Long patronId) {
	      return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(borrowingRecordService.returnBook(bookId, patronId));
	 }
	      
	 


}
