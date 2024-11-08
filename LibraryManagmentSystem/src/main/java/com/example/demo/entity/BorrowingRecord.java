package com.example.demo.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Data
public class BorrowingRecord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "bookId")
	private Book book;
	
	@ManyToOne
	@JoinColumn(name = "patronId")
	private Patron patron ;
	
	private LocalDate borrowingDate;
	private LocalDate returningDate;
	
	public void setPatron(Patron patron) {
		this.patron=patron;
	}
	
	public void setBook(Book book) {
		this.book=book;
	}
	
	public void setBorrowingDate(LocalDate borrowingDate) {
		this.borrowingDate=borrowingDate;
	}
	
	public void setReturningDate(LocalDate returningDate) {
		this.returningDate=returningDate;
	}
	
	public LocalDate getReturningDate() {
		return returningDate;
	}
	
}
