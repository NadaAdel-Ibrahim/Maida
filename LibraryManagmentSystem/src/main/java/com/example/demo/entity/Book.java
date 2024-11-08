package com.example.demo.entity;

import org.antlr.v4.runtime.misc.NotNull;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Book {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id ;
	
	@NotNull
	private String title;
	
	@NotNull
	private String author;
	
	private int publicationYear;
	
	@NotNull
	private int isbn;
	

	public void setId(Long id) {
		this.id=id;
	}
	
	
	public Long getId(Long id) {
		return this.id;
	}
	
	

}
