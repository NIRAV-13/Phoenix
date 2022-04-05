package proj.springboot.web;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import proj.springboot.admin.admin_details;
import proj.springboot.parking.Parking_details;
import proj.springboot.parking.booking_details;
import proj.springboot.payment.PaypalService;
import proj.springboot.view.view_details;
import proj.springboot.payment.Order;

import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static proj.springboot.admin.admin_cards.admin_cards;
import static proj.springboot.parking.Booking_slots.payment_cards;
import static proj.springboot.parking.reading_database.parking_cards;
import static proj.springboot.service.UserServiceImpl.email_123;
import static proj.springboot.view.view.view_cards;
import static proj.springboot.view.view.view_cards_history;


@Controller
public class MainController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@GetMapping("/index")
	public String home() {
		return "index";
	}

	@GetMapping("/products")
	public String listProducts(Model model) {
		List<Parking_details> gui_parking_details = parking_cards();
		model.addAttribute("p1", gui_parking_details);
		return "slots";
	}

	@GetMapping("/Add_slot")
	public String addslot(){return "Add_slot"; }

	@GetMapping("/Book_slot")
	public String bookslot(){return "Book_slot";}
	@GetMapping("/profile")
	public String profile(){return "profile";}

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
		ArrayList<booking_details> booking_detail_gui = payment_cards(Integer.valueOf(id));
		for (booking_details booking_detail_guis : booking_detail_gui) {
			System.out.println("Testing" + booking_detail_guis.getPlace());
			model.addAttribute("p1", booking_detail_gui.get(0));
			return "abc1";
		}
		return null;
	}

	@GetMapping(value = "/feedback/{id}")
	public String feedback(Model model, @PathVariable("id") String id) throws SQLException, ClassNotFoundException {
		ArrayList<booking_details> booking_detail_gui = payment_cards(Integer.valueOf(id));
		for (booking_details booking_detail_guis : booking_detail_gui) {
			System.out.println("Testing" + booking_detail_guis.getPlace());
			model.addAttribute("p1", booking_detail_gui.get(0));
			return "abc1";
		}
		return null;
	}
//	@GetMapping(value = "/view/{id}")
//	public String view(Model model, @PathVariable("id") Integer id) throws SQLException, ClassNotFoundException {
//		List<view_details> gui_parking_details = view_cards(id);
//		for (view_details booking_detail_guis : gui_parking_details) {
//			System.out.println("Testing" + booking_detail_guis.getUserid());
//			model.addAttribute("p1", gui_parking_details);
//			return "index";
//		}
//		return null;
//	}

	@GetMapping(value = "/history")
	public String history(Model model) throws SQLException, ClassNotFoundException {
		List<view_details> gui_parking_details = view_cards_history(email_123);
		for (view_details booking_detail_guis : gui_parking_details) {
			System.out.println("Testing" + booking_detail_guis.getUserid());
			model.addAttribute("p1", gui_parking_details);
			return "view";
		}
		return null;
	}
	@GetMapping(value = "/")
	public String view(Model model) throws SQLException, ClassNotFoundException {
		List<view_details> gui_parking_details = view_cards(email_123);
		for (view_details booking_detail_guis : gui_parking_details) {
			System.out.println("Testing" + booking_detail_guis.getUserid());
			model.addAttribute("p1", gui_parking_details);
			return "index";
		}
		return null;
	}
	@GetMapping("/admin")
	public String admin(Model model) {
		List<Parking_details> gui_parking_details = parking_cards();
		model.addAttribute("p1", gui_parking_details);
		for (Parking_details gui_parking_detail : gui_parking_details) {
			if (email_123.equals("sparsh1176@gmail.com")) {
				model.addAttribute("p1", gui_parking_details);
				return "Admin_home";
			}
		}
		return null;
	}
	@GetMapping(value = "/deletion/{id}")
	public String deletion(Model model, @PathVariable("id") long id) {
		List<admin_details> gui_parking_details = admin_cards((int) id);
		return "error";
	}
	static int id=0;

	@Autowired
	PaypalService service;

	public static final String SUCCESS_URL = "success";
	public static final String CANCEL_URL = "cancel";

	@GetMapping("/Paypal_home/{id}")
	public String payment(@ModelAttribute("order") Order order, @PathVariable("id") String id) throws PayPalRESTException, SQLException {
		this.id= Integer.parseInt(id);
		String currency ="CAD";
		String method = "PAYPAL";
		order = new Order();
		order.payed(Integer.parseInt(id));
		Payment payment = service.createPayment(order.getPrice(), currency, method,
				order.getIntent(), order.getDescription(), "http://localhost:8080/" + CANCEL_URL,
				"http://localhost:8080/" + SUCCESS_URL);
		for(Links link:payment.getLinks()) {
			if(link.getRel().equals("approval_url")) {
				return "redirect:"+link.getHref();
			}
		}
		return "redirect:/Paypal_home";
	}

	@GetMapping(value = SUCCESS_URL)
	public String successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId) {
		try {
			Payment payment = service.executePayment(paymentId, payerId);
			System.out.println(payment.toJSON());
			if (payment.getState().equals("approved")) {
				return "Paypal_success";
			}
		} catch (PayPalRESTException e) {
			System.out.println(e.getMessage());
		}
		return "Paypal_success";
	}

	@GetMapping(value = "/payment")
	public String payment(Model model) throws SQLException, ClassNotFoundException {
		List<Parking_details> gui_parking_details = parking_cards();
		ArrayList<booking_details> booking_detail_gui = payment_cards(id);
		for (booking_details booking_detail_guis : booking_detail_gui) {
			System.out.println("Testing" + booking_detail_guis.getPlace());
			model.addAttribute("p1", booking_detail_gui.get(0));
			return "abc1";
		}
		return "abc1";
	}
}
