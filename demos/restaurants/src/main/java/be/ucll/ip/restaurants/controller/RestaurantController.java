package be.ucll.ip.restaurants.controller;

import be.ucll.ip.restaurants.dto.RestaurantDTO;
import be.ucll.ip.restaurants.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/restaurant")
public class RestaurantController {
	private final RestaurantService restaurantService;

	@Autowired
	public RestaurantController(RestaurantService restaurantService) {
		this.restaurantService = restaurantService;
	}

	@GetMapping
	public String getRestaurants(Model model){
		model.addAttribute("restaurants", restaurantService.getRestaurants());
		return "restaurants";
	}

	@PostMapping
	public String addRestaurant(@ModelAttribute RestaurantDTO restaurantDTO){
		restaurantService.addRestaurant(restaurantDTO);
		return "redirect:/restaurant";
	}
}
