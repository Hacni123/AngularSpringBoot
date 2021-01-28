package com.grokonez.jwtauthentication.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grokonez.jwtauthentication.exception.ResourceNotFoundException;
import com.grokonez.jwtauthentication.model.Category;
import com.grokonez.jwtauthentication.repository.CategoryRepository;


@Service
public class CategoryService {

	@Autowired
    private CategoryRepository categoryRepository;
	
	public List<Category> getCategory(){
        return categoryRepository.findAll();
    }
    public Category getCategory(long id){
        Optional<Category> category = categoryRepository.findById(id);
        if(!category.isPresent())
                throw new ResourceNotFoundException("Category not found!");
        return category.get();
    }
    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }
    public Category updateCategory(long id,Category category){
    	category.setId(id);
        return categoryRepository.save(category);
    }
    public void deleteCategory(long id){
    	categoryRepository.deleteById(id);
    }
}
