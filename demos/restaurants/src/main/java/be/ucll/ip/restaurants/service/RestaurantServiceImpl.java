package be.ucll.ip.restaurants.service;

import be.ucll.ip.restaurants.domain.Restaurant;
import be.ucll.ip.restaurants.dto.RestaurantDTO;
import be.ucll.ip.restaurants.repository.RestaurantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImpl implements RestaurantService {
	private final RestaurantRepository repository;

	@Autowired
	public RestaurantServiceImpl(RestaurantRepository repository) {
		this.repository = repository;
	}

	@Override
	public List<Restaurant> getRestaurants() {
		return repository.getRestaurants();
	}

	@Override
	public void addRestaurant(RestaurantDTO restaurantDTO) {
		Restaurant restaurant = new Restaurant(restaurantDTO.getName(), restaurantDTO.getAddress(), restaurantDTO.getRating());
		repository.addRestaurant(restaurant);
	}
}
