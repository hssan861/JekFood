package tn.csf.JekFood.Controller;

import java.util.List;  
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;  
import org.springframework.web.bind.annotation.GetMapping;  
import org.springframework.web.bind.annotation.PathVariable;  
import org.springframework.web.bind.annotation.PostMapping;  
import org.springframework.web.bind.annotation.PutMapping;  
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tn.csf.JekFood.Model.Restaurant;
import tn.csf.JekFood.Service.RestaurantService;

//mark clrss rs Controller  
@RestController 
@CrossOrigin(origins = "*")


public class RestaurentController {


	@Autowired  
	RestaurantService rs;  

	//creating a get mapping that retrieves all the Restaurant detail from the databrse   
	@GetMapping("/restaurant")
	private List<Restaurant> getAllRestaurants()   
	{  
		return rs.getAllRestaurants();  
	}  

	//creating a get mapping that retrieves the detail of a specific restaurant  
	@GetMapping("/restaurant/{id}")  
	private Restaurant getRestaurant(@PathVariable("id") int id)   
	{  
		return rs.getRestaurantsById(id);  
	}  

	//creating a delete mapping that deletes a specified restaurant  
	@DeleteMapping("/restaurant/{id}")  
	private void deleteRestaurant(@PathVariable("id") int id)   
	{  
		rs.delete(id);  
	} 

	//create new restaurant
	@PostMapping("/restaurant")  
	private int saveRestaurant(@RequestBody Restaurant a)   
	{  
		rs.saveOrUpdate(a);  
		return a.getId();  
	} 

	//creating put mapping that updates the restaurant detail
	@PutMapping("/restaurant")  
	private Restaurant update(@RequestBody  Restaurant a)   
	{  
		rs.saveOrUpdate(a);  
		return a;  
	}  
}

