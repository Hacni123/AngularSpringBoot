package net.javaguides.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.javaguides.springboot.exception.ResourceNotFoundException;
import net.javaguides.springboot.model.Shop;
import net.javaguides.springboot.repository.ShopRepository;


@Service
public class ShopService {

	@Autowired
    private ShopRepository shopRepository;
	
	public List<Shop> getShop(){
        return shopRepository.findAll();
    }
    public Shop getShop(long shop_id){
        Optional<Shop> shop = shopRepository.findById(shop_id);
        if(!shop.isPresent())
                throw new ResourceNotFoundException("Employee not found!");
        return shop.get();
    }
    public Shop addShop(Shop shop){
        return shopRepository.save(shop);
    }
    public Shop updateShop(long shop_id,Shop shop){
    	shop.setShop_id(shop_id);
        return shopRepository.save(shop);
    }
    public void deleteShop(long shop_id){
    	shopRepository.deleteById(shop_id);
    }
}
