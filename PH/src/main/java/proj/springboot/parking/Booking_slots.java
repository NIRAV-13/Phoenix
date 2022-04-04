package proj.springboot.parking;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import static proj.springboot.parking.Database_connection.testing_connection;
import static proj.springboot.payment.payment.random_generation_number;
import static proj.springboot.service.UserServiceImpl.email_123;

public class Booking_slots {
    public static ArrayList<booking_details> payment_cards(Integer id) throws ClassNotFoundException, SQLException {
        ArrayList<booking_details> booking_detail = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = testing_connection();
        //creating statement for executing query statement
        Statement stmt1 = (Statement) connection.createStatement();
        //selecting database
        Integer used=0;
        Integer booked=0;
        String transaction_id = random_generation_number();
        Integer user_id =0;
        int rs2 = stmt1.executeUpdate("Use CSCI5308_14_TEST");
        ResultSet rs4 = stmt1.executeQuery("select * from user where email = '"+email_123+"' ");
        while(rs4.next()){
            user_id=rs4.getInt(1);
        }
        int rs5 = stmt1.executeUpdate("INSERT INTO transaction(transaction_number,UserId,parking_id) " + "VALUES ('"+transaction_id+"', '"+user_id+"', '"+id+"')");

        //finding the password stored in database
        ResultSet rs1 = stmt1.executeQuery("select * from slot where id ='" + id + "'");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String date = dtf.format(now);
        while(rs1.next()){
            booking_details bd = new booking_details();
            bd.setPlace(rs1.getString(8));
            bd.setTransactionId(transaction_id);
            bd.setId(rs1.getInt(1));
            bd.setTime(date);
            used = rs1.getInt(2);
            booked=rs1.getInt(3);
            bd.setAddress(rs1.getString(5));
            booking_detail.add(bd);
        }

//        for(booking_details bd1 : booking_detail) {
//            System.out.println(bd1.getPlace());
//            System.out.println(bd1.getTime());
//            System.out.println(bd1.getTransactionId());
//            System.out.println(bd1.getId());
//            System.out.println(bd1.getAddress());
//        }
        Integer increment =used+1;
        Integer decrement =booked-1;
        stmt1.executeUpdate("update slot set availableslots = "+increment+" where id = "+id+";");
        stmt1.executeUpdate("update slot set booked = "+decrement+" where id = "+id+";");
        return booking_detail;
    }
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        payment_cards(2);
    }
}
