package proj.springboot.parking;

public class Parking_details {
    private String parking_name;
    private String latitude;
    private String longitude;
    private int avaiable_slots;

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    private String direction;

    public int getAvaiable_slots() {
        return avaiable_slots;
    }

    public void setAvaiable_slots(int avaiable_slots) {
        this.avaiable_slots = avaiable_slots;
    }

    public String getParking_name() {
        return parking_name;
    }

    public void setParking_name(String parking_name) {
        this.parking_name = parking_name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public int getParkingid() {
        return parkingid;
    }

    public void setParkingid(int parkingid) {
        this.parkingid = parkingid;
    }



    private int parkingid;


}
