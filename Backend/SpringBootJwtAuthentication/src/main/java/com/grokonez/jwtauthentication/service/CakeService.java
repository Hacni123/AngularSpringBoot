package com.grokonez.jwtauthentication.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.grokonez.jwtauthentication.exception.ResourceNotFoundException;
import com.grokonez.jwtauthentication.model.Cake;
import com.grokonez.jwtauthentication.model.Category;
import com.grokonez.jwtauthentication.repository.CakeRepository;
import com.grokonez.jwtauthentication.repository.CategoryRepository;


@Service
public class CakeService {

	@Autowired
    private CakeRepository cakeRepository;

	@Autowired
    private CategoryService categoryService;

	    public Cake findCakeById(Long cakeid) {
	        return cakeRepository.findByCakeid(cakeid);
	    }
	    
	    public Page<Cake> findByCategoryId(Long id, Pageable pageable) {
	        return cakeRepository.findByCategoryId(id, pageable);
	    }

	    public Page<Cake> searchbykey(String keyword, Pageable pageable) {
	        return cakeRepository.findByNameContaining(keyword, pageable);
	    }
	    
    public Optional<Cake> findById(Long cakeid) {
        return cakeRepository.findById(cakeid);
    }
    
	public List<Cake> getCake(){
		Cake cake=new Cake();
        return (List<Cake>) cakeRepository.findAll();
    }
    public Cake getCake(long cakeid){
        Optional<Cake> cake = cakeRepository.findById(cakeid);
        
        if(!cake.isPresent())
                throw new ResourceNotFoundException("Cake not found!");
        return cake.get();
    }
    public Cake addCake(Cake cake){
        return cakeRepository.save(cake);
    }
    
    public Cake createCakeById(long id, Cake cake) throws Exception {
        Category category = this.categoryService.getCategory(id);
        cake.setCategory(category);
        return cakeRepository.save(cake);
    }
    public Cake updateCake(long cakeid,long id,Cake cake){
    	cake.setCakeid(cakeid);
    	Category category = this.categoryService.getCategory(id);
        cake.setCategory(category);
        return cakeRepository.save(cake);
    }
    public void deleteCake(long cakeid){
    	cakeRepository.deleteById(cakeid);
    }
}
