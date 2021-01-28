package com.grokonez.jwtauthentication.controller;

import java.text.ParseException;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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

import com.grokonez.jwtauthentication.dto.CakeDTO;
import com.grokonez.jwtauthentication.dto.OrderDTO;
import com.grokonez.jwtauthentication.model.Cake;
import com.grokonez.jwtauthentication.model.Order;
import com.grokonez.jwtauthentication.repository.CakeRepository;
import com.grokonez.jwtauthentication.service.CakeService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/auth/cakes")
public class CakeController {

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
    private CakeService cakeService;
	
	@Autowired
    private CakeRepository cakerepository;
	
	@RequestMapping("/cake/count")
	private Long getNumberOfCakes(){
	    return cakerepository.count();
	}
	
	 @GetMapping("/getAll")
	    public List<CakeDTO> getAllCakes() {
	        List<Cake> cakeList = cakeService.getCake();
	        return cakeList.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }

	 @PostMapping("/create/{id}")
	    public CakeDTO createClassById(@PathVariable(value = "id") Long id, @RequestBody CakeDTO tuitionClassDTO) throws Exception {
		 Cake cake = convertToEntity(tuitionClassDTO);
	        return convertToDTO(cakeService.createCakeById(id, cake));
	    }
	 
	 @GetMapping("/getAllCakes/{id}")
	    public List<CakeDTO> getAllCakesByCategoryId(@PathVariable(value = "id") Long id,Pageable pageable) throws Exception {
	        Page<Cake> cakeList = this.cakeService.findByCategoryId(id, pageable);
	        return cakeList.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	 
	 @GetMapping("/get/{cakeid}")
	 public CakeDTO getCake(@PathVariable(value = "cakeid") Long cakeid) throws Exception {
	     Cake cake = this.cakeService.findCakeById(cakeid);
	     return convertToDTO(cake);
	 }
	 
	 @GetMapping("/getAllCakesbykeyword/{name}")
	    public List<CakeDTO> getAllCakesByKeyword(@PathVariable(value = "name") String keyword,Pageable pageable) throws Exception {
	        Page<Cake> cakeList = this.cakeService.searchbykey(keyword, pageable);
	        return cakeList.stream()
	                .map(this::convertToDTO)
	                .collect(Collectors.toList());
	    }
	 
	 @PutMapping("/update/{cakeid}/{id}")
	 public CakeDTO updateCake(@PathVariable(value = "cakeid") Long cakeid,@PathVariable(value = "id") Long id, @RequestBody CakeDTO cakedto) throws Exception {
	     Cake cake = convertToEntity(cakedto);
	     return convertToDTO(cakeService.updateCake(cakeid,id,cake));
	 }
	 
	
	 @DeleteMapping("/delete/{id}")
		public void deleteCake(@PathVariable long id){
			cakeService.deleteCake(id);
	    }
	/* get employee by id rest api
	@GetMapping("/get/{id}")
    public Cake getCake(@PathVariable long id){
        return cakeService.getCake(id);
    }
	
	// update employee rest api
	
	@PutMapping("/update/{id}")
	public Cake createCake(@PathVariable long id,@RequestBody Cake cake){
        return cakeService.updateCake(id, cake);
    }
	
	// delete employee rest api
	@DeleteMapping("/delete/{id}")
	public void deleteCake(@PathVariable long id){
		cakeService.deleteCake(id);
    }
	*/
	private CakeDTO convertToDTO(Cake cake) {
		CakeDTO cakeDTO = modelMapper.map(cake, CakeDTO.class);
		return cakeDTO;
	}

	private Cake convertToEntity(CakeDTO cakeDTO) throws ParseException {
		Cake cake = modelMapper.map(cakeDTO, Cake.class);
		return cake;
	}
}
