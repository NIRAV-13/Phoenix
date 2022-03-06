package proj.springboot.service;

import org.springframework.security.core.userdetails.UserDetailsService;
import proj.springboot.model.User;
import proj.springboot.parking.Parking_details;
import proj.springboot.web.dto.UserRegistrationDto;

import java.util.List;

public interface UserService extends UserDetailsService{
	User save(UserRegistrationDto registrationDto);
}
