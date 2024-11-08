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
import com.example.demo.entity.Patron;
import com.example.demo.service.PatronService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/patrons")
public class PatronController {
	
	  private PatronService patronService;

	    @GetMapping("/patrons")
	    public ResponseEntity<List<Patron>> getAllPatrons() {
	        return ResponseEntity
	        		.ok (patronService.getAllPatrons());
	    }

	    @GetMapping("/patron/{id}")
	    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
	        return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(patronService.getPatronById(id));
	    }

	    @PostMapping("/patrons")
	    public ResponseEntity<Patron> addPatron(@RequestBody Patron patron) {
	        return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(patronService.addPatron(patron));
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron patron) {
	        return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(patronService.updatePatron(id, patron));
	    }

	    @DeleteMapping("/payton/{id}")
	    public ResponseEntity<Patron> deletePatron(@PathVariable Long id) {
	    	return ResponseEntity
	        		.status(HttpStatus.ACCEPTED)
	        		.body(patronService.deletePatron(id));
	    }

}
