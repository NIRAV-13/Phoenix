package proj.springboot.feedback;

import java.sql.Date;

public class feedback_details {
    private Integer userid;
    private Integer parking_id;
    private String Feedback;

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

    public String getFeedback() {
        return Feedback;
    }

    public void setFeedback(String feedback) {
        Feedback = feedback;
    }
}
