package net.javaguides.springboot.controller;

import java.util.List;

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

import net.javaguides.springboot.model.Cake;
import net.javaguides.springboot.service.CakeService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class CakeController {


	@Autowired
    private CakeService cakeService;
	
	// get all employees
	@GetMapping("/cakes")
	public List<Cake> getAllEmployees(){
		return cakeService.getCake();
	}		
	
	// create employee rest api
	@PostMapping("/cakes")
	public Cake createEmployee(@RequestBody Cake cake) {
		return cakeService.addCake(cake);
	}
	
	// get employee by id rest api
	@GetMapping("/cakes/{id}")
    public Cake getEmployee(@PathVariable long cake_id){
        return cakeService.getCake(cake_id);
    }
	
	// update employee rest api
	
	@PutMapping("/cakes/{id}")
	public Cake createEmployee(@PathVariable long cake_id,@RequestBody Cake cake){
        return cakeService.updateCake(cake_id, cake);
    }
	
	// delete employee rest api
	@DeleteMapping("/cakes/{id}")
	public void deleteEmployee(@PathVariable long cake_id){
		cakeService.deleteCake(cake_id);
    }
	
	
}
