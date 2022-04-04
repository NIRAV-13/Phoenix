package proj.springboot.admin;

import proj.springboot.parking.Parking_details;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static proj.springboot.parking.Database_connection.testing_connection;

public class admin_cards {
    public static ArrayList<admin_details> admin_cards(Integer id) {
        try {
            ArrayList<admin_details> admin_detail = new ArrayList<>();
//            String map_details = direction.direction_finder("test");
//            System.out.println(map_details);
            //tesing database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = testing_connection();
            //creating statement for executing query statement
            Statement stmt1 = (Statement) connection.createStatement();
            //selecting database
            int rs2 = stmt1.executeUpdate("Use CSCI5308_14_TEST");
            //finding the password stored in database
            Integer rs1 = stmt1.executeUpdate("delete from slot where id = '" +id+"'");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String args[]){
        admin_cards(18);
    }
}
