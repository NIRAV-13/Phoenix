package proj.springboot.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import proj.springboot.parking.Parking_details;
import proj.springboot.parking.booking_details;
import proj.springboot.parking.reading_database;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static proj.springboot.Map.direction.direction_finder;
import static proj.springboot.parking.Booking_slots.payment_cards;
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

	@GetMapping("/products")
	public String listProducts(Model model) {
		List<Parking_details> gui_parking_details = parking_cards();
		model.addAttribute("p1", gui_parking_details);
		return "slots";
	}

	@GetMapping(value = "/slotbooking/{id}")
	public String slotbooking(Model model, @PathVariable("id") long id) {
		List<Parking_details> gui_parking_details = parking_cards();
		for (Parking_details gui_parking_detail : gui_parking_details) {
			if (gui_parking_detail.getParkingid() == id) {
				model.addAttribute("p1", gui_parking_details.get((int) id - 1));
				return "abc";
			}
		}
		return null;
	}

	@GetMapping(value = "/pincode/{id}")
	public String pincode(Model model, @PathVariable("id") String id) {
		List<Parking_details> gui_parking_details = parking_cards();
		for (Parking_details gui_parking_detail : gui_parking_details) {
			if (gui_parking_detail.getParking_pincode().equals(id)) {
				System.out.println("Testing" + gui_parking_detail.getParking_pincode());
				model.addAttribute("p1", gui_parking_details.get(gui_parking_detail.getParkingid() - 1));
				return "abc1";
			} else {
				System.out.println("Hello word");
			}
		}
		return null;
	}

	@GetMapping(value = "/direction/{id}")
	public void method(HttpServletResponse httpServletResponse,@PathVariable("id") long id) {
		List<Parking_details> gui_parking_details = parking_cards();
		for (Parking_details gui_parking_detail : gui_parking_details) {
			if (gui_parking_detail.getParkingid()== id) {
				System.out.println("Testing" + gui_parking_detail.getMaps());
				httpServletResponse.setHeader("Location", gui_parking_detail.getMaps());
				httpServletResponse.setStatus(302);
			}
		}
	}
	@GetMapping(value = "/payment/{id}")
	public String payment(Model model, @PathVariable("id") String id) throws SQLException, ClassNotFoundException {
		List<Parking_details> gui_parking_details = parking_cards();
		ArrayList<booking_details> booking_detail_gui = payment_cards(Integer.valueOf(id));
		for (booking_details booking_detail_guis : booking_detail_gui) {
				System.out.println("Testing" + booking_detail_guis.getPlace());
				model.addAttribute("p1", booking_detail_gui.get(0));
				return "abc1";
		}
		return null;
	}

}
