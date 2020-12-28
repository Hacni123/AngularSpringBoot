package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.javaguides.springboot.model.Cake;

@Repository
public interface CakeRepository extends JpaRepository<Cake, Long>{

}
