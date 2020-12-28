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

import net.javaguides.springboot.model.Login;
import net.javaguides.springboot.service.LoginService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class LoginController {

	@Autowired
    private LoginService loginService;
	
	// get all employees
	@GetMapping("/login")
	public List<Login> getAllLogins(){
		return loginService.getLogin();
	}		
	
	// create employee rest api
	@PostMapping("/login")
	public Login createLogin(@RequestBody Login login) {
		return loginService.addLogin(login);
	}
	
	// get employee by id rest api
	@GetMapping("/login/{id}")
    public Login getLogin(@PathVariable long login_id){
        return loginService.getLogin(login_id);
    }
	
	// update employee rest api
	
	@PutMapping("/login/{id}")
	public Login createLogin(@PathVariable long login_id,@RequestBody Login login){
        return loginService.updateLogin(login_id, login);
    }
	
	// delete employee rest api
	@DeleteMapping("/login/{id}")
	public void deleteLogin(@PathVariable long login_id){
		loginService.deleteLogin(login_id);
    }
	
	
}
