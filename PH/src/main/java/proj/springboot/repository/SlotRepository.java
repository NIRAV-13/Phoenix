package proj.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import proj.springboot.model.Slot;

@Repository
public interface SlotRepository extends JpaRepository<Slot, Long>{
	Slot findByPincode(String pincode);
}
