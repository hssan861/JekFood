package tn.csf.JekFood.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import tn.csf.JekFood.Repository.RestaurantRepository;
import tn.csf.JekFood.Model.Restaurant;

@Service
public class RestaurantService {
	

		@Autowired  
		RestaurantRepository rR;  


		//getting all restaurants record by using the method findaAll() of CrudRepository  
		public List<Restaurant> getAllRestaurants()   
		{  
			List<Restaurant> Restaurants = new ArrayList<Restaurant>();  
			rR.findAll().forEach(a -> Restaurants.add(a));  
			return Restaurants;  	
		}  

		//getting a specific record by using the method findById() of CrudRepository  
		public Restaurant getRestaurantsById(int id)   
		{  
			return rR.findById(id).get();  
		}  


		//saving a specific record by using the method save() of CrudRepository  
		public void saveOrUpdate(Restaurant Restaurants)   
		{  
			rR.save(Restaurants);  
		} 

		//deleting a specific record by using the method deleteById() of CrudRepository  
		public void delete(int id)   
		{  
			rR.deleteById(id);  
		} 

	
}
