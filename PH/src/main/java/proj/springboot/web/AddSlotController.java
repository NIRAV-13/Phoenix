package proj.springboot.web;

import ch.qos.logback.core.net.SyslogOutputStream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import proj.springboot.service.SlotService;
import proj.springboot.web.dto.AddSlotDto;
import proj.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/Add_slot_form")
public class AddSlotController {

	@Autowired
	private SlotService slotService;

	@ModelAttribute("slot")
	public AddSlotDto addSlotDto() { return new AddSlotDto();
	}

	@GetMapping
	public String showAddslotform() {
		return "Add_slot_form";
	}

	@PostMapping
	public String registerSlot(@ModelAttribute("slot") AddSlotDto addSlotDto) {
		slotService.save(addSlotDto);
		return "redirect:/index";
	}


}
