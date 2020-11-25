package net.javaguides.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Booking;
import net.javaguides.springboot.repository.BookingRepository;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class BookingController {
	
	@Autowired
	private BookingRepository bookingRepository;
	
	// get all booking
		@GetMapping("/bookings")
		public List<Booking> getAllBookings(){
			return bookingRepository.findAll();
		}	
		
		// create booking rest api
		@PostMapping("/bookings")
		public Booking createBooking(@RequestBody Booking booking) {
			return bookingRepository.save(booking);
		}
		
		// get booking by id rest api
		@GetMapping("/bookings/{id}")
		public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
			Booking booking = bookingRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + id));
			return ResponseEntity.ok(booking);
		}
			
			// update booking rest api
			
			@PutMapping("/bookings/{id}")
			public ResponseEntity<Booking> updateBooking(@PathVariable Long id, @RequestBody Booking bookingDetails){
				Booking booking = bookingRepository.findById(id)
						.orElseThrow(() -> new ResourceNotFoundException("Booking not exist with id :" + id));
				
				booking.setName(bookingDetails.getName());
				booking.setPhone(bookingDetails.getPhone());
				booking.setEmail(bookingDetails.getEmail());
				booking.setId_num(bookingDetails.getId_num());
				booking.setGender(bookingDetails.getGender());
				booking.setAddress(bookingDetails.getAddress());
				
				Booking updateBooking = bookingRepository.save(booking);
				return ResponseEntity.ok(updateBooking);
		}
		
	
}
