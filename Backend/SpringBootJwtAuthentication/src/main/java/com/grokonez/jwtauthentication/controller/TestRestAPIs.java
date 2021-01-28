package com.grokonez.jwtauthentication.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.model.User;
import com.grokonez.jwtauthentication.repository.UserRepository;



@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class TestRestAPIs {
	
	@Autowired
    private UserRepository userinfoRepository;
    @RequestMapping(value = "/findby/{username}")
    public Optional<User> findByUsername(@PathVariable String username)
    {
    	Optional<User> userinfo = userinfoRepository.findByUsername(username);
        System.out.println(userinfo.toString());
        return userinfo;
    }
    
    
    
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Project Management Board";
	}
	
	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}
}