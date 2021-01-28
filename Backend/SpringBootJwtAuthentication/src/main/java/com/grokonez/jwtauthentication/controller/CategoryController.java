package com.grokonez.jwtauthentication.controller;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grokonez.jwtauthentication.dto.CategoryDTO;
import com.grokonez.jwtauthentication.model.Category;
import com.grokonez.jwtauthentication.repository.CategoryRepository;
import com.grokonez.jwtauthentication.service.CategoryService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth/categories")
public class CategoryController {

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
    private CategoryService categoryService;
	
	@Autowired
    private CategoryRepository categoryrepository;
	
	@RequestMapping("/category/count")
	private Long getNumberOfCakes(){
	    return categoryrepository.count();
	}
	
	 @GetMapping("/getAll")
	    public List<CategoryDTO> getAllCategory() {
	        List<Category> categoryList = categoryService.getCategory();
	        return categoryList.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	 @PostMapping("/create")
	    public CategoryDTO createCake(@RequestBody CategoryDTO categoryDTO) throws Exception{
		 Category category = convertToEntity(categoryDTO);
	        return convertToDTO(categoryService.addCategory(category));
	    }
	 
	
		@DeleteMapping("/delete/{id}")
		public void deleteCategory(@PathVariable long id){
			categoryService.deleteCategory(id);
	    }
	
		@GetMapping("/getAlll")
		public List<Category> getAllCategory1(){
			return categoryService.getCategory();
		}
	
	
	/*
			
	
	// create employee rest api
	@PostMapping("/create")
	public Category createCategory(@RequestBody Category category) {
		return categoryService.addCategory(category);
	}
	
	
	// get employee by id rest api
	@GetMapping("/get/{id}")
    public Category getCategory(@PathVariable long id){
        return categoryService.getCategory(id);
    }
	
	// update employee rest api
	
	@PutMapping("/update/{id}")
	public Category createCategory(@PathVariable long id,@RequestBody Category category){
        return categoryService.updateCategory(id, category);
    }
	
	
	*/
	
	private CategoryDTO convertToDTO(Category category) {
		CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
		return categoryDTO;
	}

	private Category convertToEntity(CategoryDTO categoryDTO) throws ParseException {
		Category category = modelMapper.map(categoryDTO, Category.class);
		return category;
	}
}
