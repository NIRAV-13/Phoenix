package proj.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import proj.springboot.model.Slot;
import proj.springboot.model.User;
import proj.springboot.repository.SlotRepository;
import proj.springboot.web.dto.AddSlotDto;

@Service
public class SlotServiceImpl implements SlotService {

	@Autowired
	private SlotRepository slotRepository;

//	@Autowired
//	private BCryptPasswordEncoder passwordEncoder;


	@Override
	public AddSlotDto save(AddSlotDto addSlotDto) {
		Slot slot = new Slot(addSlotDto.getParkingName(),
				addSlotDto.getSlotPrice(),addSlotDto.getAvailableslots(),addSlotDto.getParkingLocation(),addSlotDto.getBooked(),
				addSlotDto.getemail_id(),
				addSlotDto.getPincode(),addSlotDto.getDate(),addSlotDto.getStartTime(),
				addSlotDto.getEndTime());
//////		User users = new User();
//		slot.setPincode(addSlotDto.getPincode());
//		System.out.println("here");
		slot = slotRepository.save(slot);

		return addSlotDto;
	}



}
