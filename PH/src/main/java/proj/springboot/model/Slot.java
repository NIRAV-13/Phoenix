package proj.springboot.model;

import javax.persistence.*;

@Entity
@Table(name =  "slot", uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Slot<parkingName, parkingLocation, pincode> {

	@Id
	@GeneratedValue(strategy =  GenerationType.IDENTITY)
	private Long id;

	@Column(name = "parkingName")
	private String parkingName;

	@Column(name = "slotPrice")
	private String slotPrice;

	@Column(name = "parkingLocation")
	private String parkingLocation;

	@Column(name = "pincode")
	private String pincode;

	@Column(name = "date")
	private String date;

	@Column(name = "startTime")
	private String startTime;

	@Column(name = "endTime")
	private String endTime;


//	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	@JoinTable(
//			name = "users_slot",
//			joinColumns = @JoinColumn(
//		            name = "slot_id", referencedColumnName = "id"),
//			inverseJoinColumns = @JoinColumn(
//				            name = "user_id", referencedColumnName = "id"))
//
//	private Collection<Role> roles;
//
	public Slot() {
		
	}

	public Slot(String parkingName, String slotPrice, String parkingLocation, String pincode, String date, String startTime, String endTime) {
		this.parkingName = parkingName;
		this.slotPrice = slotPrice;
		this.parkingLocation = parkingLocation;
		this.pincode = pincode;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;

	}

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getParkingName() {
		return parkingName;
	}
	public void setParkingName(String parkingName) {
		this.parkingName = parkingName;
	}

	public String getSlotPrice() {
		return slotPrice;
	}
	public void setSlotPrice(String slotPrice) {
		this.slotPrice = slotPrice;
	}

	public String getParkingLocation() {
		return parkingLocation;
	}
	public void setParkingLocation(String parkingLocation) {
		this.parkingLocation = parkingLocation;
	}

	public String getPincode() {return pincode;}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {return startTime;	}
	public void setStartTime(String startTime) {this.startTime = startTime;	}

	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

}
