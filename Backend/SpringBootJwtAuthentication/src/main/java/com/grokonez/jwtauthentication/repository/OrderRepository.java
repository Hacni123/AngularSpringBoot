package com.grokonez.jwtauthentication.repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.Order;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{
	Optional<Order> findByUserId(Long id);
	Optional<Order> findByorderidAndUserId(Long orderid, Long id);
}
