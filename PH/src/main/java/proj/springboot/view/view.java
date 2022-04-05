package proj.springboot.view;

import proj.springboot.parking.Parking_details;
import proj.springboot.parking.booking_details;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;

import static proj.springboot.parking.Database_connection.testing_connection;
import static proj.springboot.payment.payment.random_generation_number;

public class view {
    public static ArrayList<view_details> view_cards_history(String id) throws ClassNotFoundException, SQLException {
        ArrayList<view_details> view_detail = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = testing_connection();
        //creating statement for executing query statement
        Statement stmt1 = (Statement) connection.createStatement();
        //selecting database
        int rs2 = stmt1.executeUpdate("Use CSCI5308_14_TEST");
        ResultSet rs4 = stmt1.executeQuery("select * from transaction tr inner join user usr on usr.id = tr.Userid inner join slot st on tr.parking_id= st.id where usr.email='"+id+"'");
        if(rs4.isBeforeFirst()){
            while (rs4.next()) {
                long millis=System.currentTimeMillis();
                String date= new Date(millis).toString();
                if(!rs4.getDate(18).equals(date)) {
                    view_details vd = new view_details();
                    vd.setTransaction_number(rs4.getString(2));
                    vd.setParking_address(rs4.getString(21));
                    vd.setParking_location(rs4.getString(22));
                    vd.setDate(rs4.getDate(18));
                    view_detail.add(vd);
                }
            }
        }
        if(!rs4.isBeforeFirst()){
            view_details vd = new view_details();
            vd.setTransaction_number(null);
            vd.setParking_address(null);
            vd.setParking_location(null);
            vd.setDate(null);
            view_detail.add(vd);
        }


        for(view_details v1 : view_detail){
            System.out.println(v1.getParking_address());
            System.out.println(v1.getParking_location());
            System.out.println(v1.getTransaction_number());
        }
        return view_detail;
    }
    public static ArrayList<view_details> view_cards(String id) throws ClassNotFoundException, SQLException {
        ArrayList<view_details> view_detail1 = new ArrayList<>();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = testing_connection();
        //creating statement for executing query statement
        Statement stmt1 = (Statement) connection.createStatement();
        //selecting database
        int rs2 = stmt1.executeUpdate("Use CSCI5308_14_TEST");
        ResultSet rs4 = stmt1.executeQuery("select * from transaction tr inner join user usr on usr.id = tr.Userid inner join slot st on tr.parking_id= st.id where usr.email='"+id+"'");
        if(rs4.isBeforeFirst()){
            while (rs4.next()) {
                System.out.println(rs4.getDate(18));
                long millis=System.currentTimeMillis();
                String date= new Date(millis).toString();
                if(rs4.getString(18).equals(date)) {
                    view_details vd = new view_details();
                    vd.setTransaction_number(rs4.getString(2));
                    vd.setParking_address(rs4.getString(21));
                    vd.setParking_location(rs4.getString(22));
                    vd.setDate(rs4.getDate(18));
                    view_detail1.add(vd);
                }
            }
        }
        if(!rs4.isBeforeFirst()){
            view_details vd = new view_details();
            vd.setTransaction_number(null);
            vd.setParking_address(null);
            vd.setParking_location(null);
            vd.setDate(null);
            view_detail1.add(vd);
        }


        for(view_details v1 : view_detail1){
            System.out.println(v1.getParking_address());
            System.out.println(v1.getParking_location());
            System.out.println(v1.getTransaction_number());
        }
        return view_detail1;
    }
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        view_cards("sparsh1176@gmail.com");
    }
}
