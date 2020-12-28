package net.javaguides.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

import net.javaguides.springboot.model.Booking;

@CrossOrigin("http://localhost:4200")
@Repository
public interface BookingRepository extends JpaRepository<Booking, Long>{

}
