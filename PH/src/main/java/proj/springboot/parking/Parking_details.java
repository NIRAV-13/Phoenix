package proj.springboot.parking;

import java.sql.Time;
import java.util.Date;

public class Parking_details {
    private String parking_name;
    private Date date;
    private Integer slot_price;
    private String parking_location;
    private Integer booked_slots;

    public Integer getAvailable_slots() {
        return available_slots;
    }

    public void setAvailable_slots(Integer available_slots) {
        this.available_slots = available_slots;
    }

    private Integer available_slots;

    public Integer getBooked_slots() {
        return booked_slots;
    }

    public void setBooked_slots(Integer booked_slots) {
        this.booked_slots = booked_slots;
    }

    public String getParking_name() {
        return parking_name;
    }

    public void setParking_name(String parking_name) {
        this.parking_name = parking_name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Integer getSlot_price() {
        return slot_price;
    }

    public void setSlot_price(Integer slot_price) {
        this.slot_price = slot_price;
    }

    public String getParking_location() {
        return parking_location;
    }

    public void setParking_location(String parking_location) {
        this.parking_location = parking_location;
    }

    public String getParking_pincode() {
        return parking_pincode;
    }

    public void setParking_pincode(String parking_pincode) {
        this.parking_pincode = parking_pincode;
    }

    public Time getStarting_time() {
        return starting_time;
    }

    public void setStarting_time(Time starting_time) {
        this.starting_time = starting_time;
    }

    public Time getEnd_time() {
        return end_time;
    }

    public void setEnd_time(Time end_time) {
        this.end_time = end_time;
    }

    public Integer getTotal_slots() {
        return total_slots;
    }

    public void setTotal_slots(Integer total_slots) {
        this.total_slots = total_slots;
    }

    public Integer getParkingid() {
        return parkingid;
    }

    public void setParkingid(Integer parkingid) {
        this.parkingid = parkingid;
    }

    private String parking_pincode;
    private Time starting_time;
    private Time end_time;
    private Integer total_slots;
    private Integer parkingid;
}
