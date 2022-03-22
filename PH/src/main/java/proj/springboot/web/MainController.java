package proj.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.springboot.parking.Parking_details;
import proj.springboot.parking.reading_database;

import java.util.List;

import static proj.springboot.parking.reading_database.parking_cards;

@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/")
	public String home() {
		return "index";
	}

	@RequestMapping("/products")
	public String listProducts(Model model){
		List<Parking_details> gui_parking_details = parking_cards();
		model.addAttribute("p1",gui_parking_details);
		return "products";
	}
	@RequestMapping("/map")
	public String map(Model model){
		return "map";
	}

}
