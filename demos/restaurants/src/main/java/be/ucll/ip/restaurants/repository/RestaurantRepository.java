package be.ucll.ip.restaurants.repository;

import be.ucll.ip.restaurants.domain.Restaurant;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RestaurantRepository {
	private List<Restaurant> list;

	public RestaurantRepository() {
		list = new ArrayList<>();
		list.add(new Restaurant("Alma 1", "Tiensestraat 115 – 3000 Leuven", 3.9));
		list.add(new Restaurant("Alma 2", "E. Van Evenstraat 2 – 3000 Leuven", 4.5));
		list.add(new Restaurant("Alma 3", "Steengroevenlaan 3 – 3001 Heverlee", 4.1));

	}

	public List<Restaurant> getRestaurants() {
		return list;
	}


	public void addRestaurant(Restaurant restaurant) {
		list.add(restaurant);
	}
}
