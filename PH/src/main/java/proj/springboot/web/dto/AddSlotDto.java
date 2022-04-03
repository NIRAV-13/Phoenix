package proj.springboot.web.dto;

public class AddSlotDto {
	private String booked;

	public String getBooked() {
		return booked;
	}

	public void setBooked(String booked) {
		this.booked = booked;
	}

	private String parkingName;
	private String slotPrice;
	private String parkingLocation;
	private String pincode;
	private String date;
	private String startTime;
	private String endTime;
	private String availableslots;
	private String email_id;

	public String getEmail_id() {
		return email_id;
	}

	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}

	public String getAvailableslots() {
		return availableslots;
	}

	public void setAvailableslots(String availableslots) {
		this.availableslots = availableslots;
	}

	public AddSlotDto(){

	}

	public AddSlotDto(String parkingName, String slotPrice,String Booked, String availableslots, String parkingLocation, String pincode, String date, String startTime, String endTime) {
		super();
		this.booked=Booked;
		this.parkingName = parkingName;
		this.slotPrice = slotPrice;

		this.parkingLocation = parkingLocation;
		this.pincode = pincode;
		this.date = date;
		this.startTime = startTime;
		this.endTime = endTime;

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

	public String getPincode() {
		return pincode;
	}
	public void setPincode(String paPncode) {
		this.pincode = paPncode;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
}
