package com.grokonez.jwtauthentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.exception.ResourceNotFoundException;
import com.grokonez.jwtauthentication.model.Login;
import com.grokonez.jwtauthentication.repository.LoginRepository;


@Service
public class LoginService {

	@Autowired
    private LoginRepository loginRepository;
	
	public List<Login> getLogin(){
        return loginRepository.findAll();
    }
    public Login getLogin(long login_id){
        Optional<Login> login = loginRepository.findById(login_id);
        if(!login.isPresent())
                throw new ResourceNotFoundException("Login not found!");
        return login.get();
    }
    public Login addLogin(Login login){
        return loginRepository.save(login);
    }
    public Login updateLogin(long login_id,Login login){
    	login.setLogin_id(login_id);
        return loginRepository.save(login);
    }
    public void deleteLogin(long login_id){
    	loginRepository.deleteById(login_id);
    }
}
