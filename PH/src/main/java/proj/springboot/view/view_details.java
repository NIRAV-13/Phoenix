package proj.springboot.view;

import java.sql.Date;

public class view_details {
    private String transaction_number;
    private Integer userid;
    private Integer parking_id;
    private String parking_location;
    private String parking_address;
    private Date date;

    public String getParking_location() {
        return parking_location;
    }

    public void setParking_location(String parking_location) {
        this.parking_location = parking_location;
    }

    public String getParking_address() {
        return parking_address;
    }

    public void setParking_address(String parking_address) {
        this.parking_address = parking_address;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTransaction_number() {
        return transaction_number;
    }

    public void setTransaction_number(String transaction_number) {
        this.transaction_number = transaction_number;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getParking_id() {
        return parking_id;
    }

    public void setParking_id(Integer parking_id) {
        this.parking_id = parking_id;
    }
}
