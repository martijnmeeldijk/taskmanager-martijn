package be.ucll.ip.restaurants.service;

import be.ucll.ip.restaurants.domain.Restaurant;
import be.ucll.ip.restaurants.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {
	public List<Restaurant> getRestaurants();

	void addRestaurant(RestaurantDTO restaurantDTO);
}
