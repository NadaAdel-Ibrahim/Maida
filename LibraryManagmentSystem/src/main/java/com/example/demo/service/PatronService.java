package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.entity.Book;
import com.example.demo.entity.Patron;
import com.example.demo.repository.PatronRepository;
import com.example.demo.service.exceptions.ResourceNotFoundException;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class PatronService {
	
	private PatronRepository patronRepository;
	
	public List<Patron>getAllPatrons(){
		return patronRepository.findAll();
	}
	
	public Patron getPatronById(Long id) {
		return patronRepository.findById(id)
				.orElseThrow(
						() -> new ResourceNotFoundException("Patron with" + id + "Not Found"));
	}
	
	public Patron addPatron(Patron patron) {
		return patronRepository.save(patron);
	}
	
	public Patron deletePatron(Long id) {
		Patron existPatron = patronRepository.findById(id).get();
		patronRepository.deleteById(id);
		return existPatron;
		
	}
	
	public Patron updatePatron(Long id , Patron patron) {	
			patron.setId(id);
			return patronRepository.save(patron);
		
	}

}
