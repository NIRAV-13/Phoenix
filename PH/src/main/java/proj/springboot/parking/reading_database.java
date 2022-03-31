package proj.springboot.parking;

import proj.springboot.Map.direction;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static proj.springboot.parking.Database_connection.testing_connection;


public class reading_database {

    private static String Userid;

    static List<String> Userid(String username) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = testing_connection();
            Statement stmt1 = (Statement) connection.createStatement();
            //creating a list for stroing the list of notes and reference
            ArrayList<String> list_notesAndReferences = new ArrayList<>();
            //selecting notes from family_note based on the person id
            int rs2 = stmt1.executeUpdate("Use User1" );
            ResultSet rs1 = stmt1.executeQuery("select * from User_details where Name = '" + username + "'" );
            while (rs1.next()) {
                Userid = rs1.getString(1);
                System.out.println(rs1.getString(1));
                System.out.println(rs1.getString(2));
                System.out.println(rs1.getString(3));
                System.out.println(rs1.getString(4));
                list_notesAndReferences.add(Userid);
            }

            return list_notesAndReferences;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    static int retreving_spots(int id) {
        try {
            int initial_available_slots=0;
            int used_spots=0;
            //tesing database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = testing_connection();
            //creating statement for executing query statement
            Statement stmt1 = (Statement) connection.createStatement();
            //selecting database
            int rs2 = stmt1.executeUpdate("Use User1");
            //finding the password stored in database
            ResultSet rs1 = stmt1.executeQuery("select * from parking_detail where parking_id = '" + id + "'");
            //retreving the value stored in database
            while(rs1.next()){
                //getting value of total initial slots available
                initial_available_slots= rs1.getInt(1);
                //getting value of total used slots
                used_spots= rs1.getInt(2);
            }
            //available slots for booking
            int available_slots=initial_available_slots-used_spots;
            System.out.println(available_slots);
            return available_slots;

        } catch (Exception e) {
            System.out.println(e);
            //returning false if the try statement is not executed properly
            return 0;
        }
    }
    public static ArrayList<Parking_details> parking_cards() {
        try {
            ArrayList<Parking_details> parking_details = new ArrayList<>();
            String map_details = direction.direction_finder("test");
            System.out.println(map_details);
            int initial_available_slots=0;
            int used_spots=0;
            //tesing database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = testing_connection();
            //creating statement for executing query statement
            Statement stmt1 = (Statement) connection.createStatement();
            //selecting database
            int rs2 = stmt1.executeUpdate("Use User1");
            //finding the password stored in database
            ResultSet rs1 = stmt1.executeQuery("select * from parking_location pl inner join parking_detail pd where pd.parking_id = pl.parking_id");
            //retreving the value stored in database
            while(rs1.next()){
                //getting value of total initial slots available
                Parking_details pd = new Parking_details();
                pd.setLatitude(rs1.getString(1));
                pd.setLongitude(rs1.getString(2));
                pd.setParkingid(rs1.getInt(3));
                initial_available_slots=rs1.getInt(6);
                used_spots=rs1.getInt(7);
                pd.setAvaiable_slots(initial_available_slots-used_spots);
                pd.setDirection(map_details);
                parking_details.add(pd);
            }
            for(Parking_details pd1 : parking_details){
                System.out.println(pd1.getParkingid());
                System.out.println(pd1.getAvaiable_slots());
                System.out.println(pd1.getLatitude());
                System.out.println(pd1.getLongitude());
                System.out.println(pd1.getDirection());
            }
            return parking_details;
        } catch (Exception e) {
            System.out.println(e);
            //returning false if the try statement is not executed properly
            return null;
        }
    }
    public static void main(String[] args) throws IOException {
//        Userid("Sparsh");
//        retreving_spots(1);
        parking_cards();
    }
}
