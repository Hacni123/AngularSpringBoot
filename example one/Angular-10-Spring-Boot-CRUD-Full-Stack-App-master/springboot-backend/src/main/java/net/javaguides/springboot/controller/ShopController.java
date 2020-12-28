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

import net.javaguides.springboot.model.Shop;
import net.javaguides.springboot.service.ShopService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class ShopController {

	@Autowired
    private ShopService shopService;
	
	// get all employees
	@GetMapping("/shops")
	public List<Shop> getAllEmployees(){
		return shopService.getShop();
	}		
	
	// create employee rest api
	@PostMapping("/shops")
	public Shop createEmployee(@RequestBody Shop shop) {
		return shopService.addShop(shop);
	}
	
	// get employee by id rest api
	@GetMapping("/shops/{id}")
    public Shop getEmployee(@PathVariable long shop_id){
        return shopService.getShop(shop_id);
    }
	
	// update employee rest api
	
	@PutMapping("/shops/{id}")
	public Shop createEmployee(@PathVariable long shop_id,@RequestBody Shop shop){
        return shopService.updateShop(shop_id, shop);
    }
	
	// delete employee rest api
	@DeleteMapping("/shops/{id}")
	public void deleteEmployee(@PathVariable long shop_id){
		shopService.deleteShop(shop_id);
    }
	
	
}
