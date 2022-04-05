package proj.springboot.feedback;


import java.sql.*;
import java.util.ArrayList;

import static proj.springboot.parking.Database_connection.testing_connection;
import static proj.springboot.service.UserServiceImpl.email_123;

public class feedback {
    public static ArrayList<feedback_details> view_feedback(Integer id,String feedback) throws ClassNotFoundException, SQLException {
        ArrayList<feedback_details> view_detail = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = testing_connection();
        //creating statement for executing query statement
        Statement stmt1 = (Statement) connection.createStatement();
        //selecting database
        Integer user_id = 0;
        email_123="sparsh@gmail.com";
        System.out.println(email_123);

        ResultSet rs4 = stmt1.executeQuery("select * from user where email = '"+email_123+"' ");
        while(rs4.next()){
            user_id=rs4.getInt(1);
        }
        System.out.println(user_id);
        int rs5 = stmt1.executeUpdate("INSERT INTO feedback (UserId,parking_id,feedback) " + "VALUES ('"+user_id+"','"+id+"','"+feedback+"')");
        return view_detail;
    }
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        view_feedback(1,"Hello Test");
    }

}
