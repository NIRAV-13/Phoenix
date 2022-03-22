package proj.springboot.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import proj.springboot.service.UserService;
import proj.springboot.web.dto.UserRegistrationAdding;
import proj.springboot.web.dto.UserRegistrationDto;

@Controller
@RequestMapping("/AddingSlots")
public class UserRegistrationControllerSlots {

    private UserService userService;

    public UserRegistrationControllerSlots(UserService userService) {
        super();
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserRegistrationAdding UserRegistrationAdding() {
        return new UserRegistrationAdding();
    }

    @GetMapping
    public String showRegistrationForm() {
        return "Addingslots";
    }

    @PostMapping
    public String registerUser(@ModelAttribute("user") UserRegistrationDto registrationDto) {
        userService.save(registrationDto);
        return "redirect:/registration?success";
    }
}
