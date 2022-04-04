package proj.springboot.admin;

import java.sql.Date;

public class admin_details {
    private String slot_name;
    private String slot_location;
    private String Owner;
    private String time;
    private Date date;

    public String getSlot_name() {
        return slot_name;
    }

    public void setSlot_name(String slot_name) {
        this.slot_name = slot_name;
    }

    public String getSlot_location() {
        return slot_location;
    }

    public void setSlot_location(String slot_location) {
        this.slot_location = slot_location;
    }

    public String getOwner() {
        return Owner;
    }

    public void setOwner(String owner) {
        Owner = owner;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
