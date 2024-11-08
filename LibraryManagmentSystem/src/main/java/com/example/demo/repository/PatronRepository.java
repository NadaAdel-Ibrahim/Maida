package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Patron;

public interface PatronRepository extends JpaRepository<Patron, Long> {

}
