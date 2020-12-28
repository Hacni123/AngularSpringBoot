package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Cake;
import net.javaguides.springboot.repository.CakeRepository;

@Service
public class CakeService {

	@Autowired
    private CakeRepository cakeRepository;
	
	public List<Cake> getCake(){
        return cakeRepository.findAll();
    }
    public Cake getCake(long cake_id){
        Optional<Cake> cake = cakeRepository.findById(cake_id);
        if(!cake.isPresent())
                throw new ResourceNotFoundException("Cake not found!");
        return cake.get();
    }
    public Cake addCake(Cake cake){
        return cakeRepository.save(cake);
    }
    public Cake updateCake(long cake_id,Cake cake){
    	cake.setCake_id(cake_id);
        return cakeRepository.save(cake);
    }
    public void deleteCake(long cake_id){
    	cakeRepository.deleteById(cake_id);
    }
}
