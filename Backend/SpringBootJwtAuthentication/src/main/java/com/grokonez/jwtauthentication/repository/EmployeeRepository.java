package com.grokonez.jwtauthentication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.grokonez.jwtauthentication.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{

}
