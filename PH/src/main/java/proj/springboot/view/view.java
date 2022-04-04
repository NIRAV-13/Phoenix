package proj.springboot.view;

import proj.springboot.parking.Parking_details;
import proj.springboot.parking.booking_details;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static proj.springboot.parking.Database_connection.testing_connection;
import static proj.springboot.payment.payment.random_generation_number;

public class view {
    public static ArrayList<view_details> view_cards(Integer id) throws ClassNotFoundException, SQLException {
        ArrayList<view_details> view_detail = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = testing_connection();
        //creating statement for executing query statement
        Statement stmt1 = (Statement) connection.createStatement();
        //selecting database
        int rs2 = stmt1.executeUpdate("Use CSCI5308_14_TEST");
        ResultSet rs4 = stmt1.executeQuery("select * from transaction tr inner join user st on st.id = tr.Userid where tr.Userid='"+id+"'");
        while (rs4.next()) {
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            System.out.println(date);
            System.out.println(rs4.getDate(8));
            if(rs4.getDate(8).equals(date)) {
                view_details vd = new view_details();
                vd.setTransaction_number(rs4.getString(2));
                vd.setParking_address(rs4.getString(9));
                vd.setParking_location(rs4.getString(12));
                vd.setDate(rs4.getDate(8));
                view_detail.add(vd);
            }
        }
        for(view_details v1 : view_detail){
            System.out.println(v1.getUserid());
            System.out.println(v1.getParking_id());
            System.out.println(v1.getTransaction_number());
        }
        return view_detail;
    }
    public static ArrayList<view_details> view_cards_history(Integer id) throws ClassNotFoundException, SQLException {
        ArrayList<view_details> view_detail1 = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = testing_connection();
        //creating statement for executing query statement
        Statement stmt1 = (Statement) connection.createStatement();
        //selecting database
        int rs2 = stmt1.executeUpdate("Use CSCI5308_14_TEST");
        ResultSet rs4 = stmt1.executeQuery("select * from transaction tr inner join slot st on st.id = tr.Userid where tr.Userid='"+id+"'");
        while (rs4.next()) {
            long millis=System.currentTimeMillis();
            java.sql.Date date=new java.sql.Date(millis);
            System.out.println(date);
            System.out.println(rs4.getDate(8));
            if(rs4.getDate(8).equals(date)){
                System.out.println("Completed");
                view_details vd = new view_details();
                vd.setTransaction_number(rs4.getString(2));
                vd.setParking_address(rs4.getString(9));
                vd.setParking_location(rs4.getString(12));
                vd.setDate(rs4.getDate(8));
                view_detail1.add(vd);
            }

        }
        for(view_details v1 : view_detail1){
            System.out.println(v1.getUserid());
            System.out.println(v1.getParking_id());
            System.out.println(v1.getTransaction_number());
        }
        return view_detail1;
    }
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        view_cards_history(1);
    }
}
