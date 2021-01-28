package com.grokonez.jwtauthentication.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.grokonez.jwtauthentication.model.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long>{

	Page<Cart> findByUserId(@Param("id") Long id, Pageable pageable);
	
}
