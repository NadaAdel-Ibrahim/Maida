package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Book;
import com.example.demo.entity.BorrowingRecord;
import com.example.demo.entity.Patron;

public interface BorrowingRecordRepository extends JpaRepository<BorrowingRecord, Long>{	
    
    List<BorrowingRecord> findByBookAndPatron(Book book, Patron patron);
    

}
