package com.grokonez.jwtauthentication.repository;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;


import com.grokonez.jwtauthentication.model.Cake;


@Repository
public interface CakeRepository extends CrudRepository<Cake, Long>{
	 Cake findByCakeid(Long cakeid);
	 
	
	Page<Cake> findByCategoryId(@Param("id") Long id, Pageable pageable);
	
	
	Page<Cake> findByNameContaining(@Param("name") String keyword, Pageable pageable);
	

	
}
