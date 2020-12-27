package net.javaguides.springboot.repository;

import org.springframework.data.domain.Page;  
import org.springframework.data.domain.Pageable;  
import org.springframework.data.jpa.repository.JpaRepository;  
import org.springframework.data.jpa.repository.Modifying;  
import org.springframework.data.jpa.repository.Query;

import net.javaguides.springboot.model.Book;

import javax.transaction.Transactional;

public interface BookRepository extends JpaRepository<Book, Integer>{  
}