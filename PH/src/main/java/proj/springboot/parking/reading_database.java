package proj.springboot.parking;

//import proj.springboot.Map.direction;

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
//            String map_details = direction.direction_finder("test");
//            System.out.println(map_details);
            int initial_available_slots=0;
            int used_spots=0;
            //tesing database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = testing_connection();
            //creating statement for executing query statement
            Statement stmt1 = (Statement) connection.createStatement();
            //selecting database
            int rs2 = stmt1.executeUpdate("Use CSCI5308_14_TEST");
            //finding the password stored in database
            ResultSet rs1 = stmt1.executeQuery("select * from parking");
            //retreving the value stored in database
            while(rs1.next()){
                //getting value of total initial slots available
                Parking_details pd = new Parking_details();
//                pd.setDate(rs1.getDate(6));
                pd.setParking_name(rs1.getString(11));
                pd.setId(rs1.getInt(1));
                pd.setTotal_slots(rs1.getInt(7));
                int available_slots = rs1.getInt(7)-rs1.getInt(8);
                pd.setAvailable_slots(available_slots);
                pd.setParking_location(rs1.getString(3));
                pd.setParkingid(rs1.getInt(2));
                pd.setParking_pincode(rs1.getString(5));
                pd.setBooked_slots(rs1.getInt(8));
                pd.setEnd_time(rs1.getTime(10));
                pd.setStarting_time(rs1.getTime(9));
                pd.setSlot_price((rs1.getInt(4)));
                pd.setMaps(direction.direction_finder(rs1.getInt(2)));
                parking_details.add(pd);
            }
            for(Parking_details pd1 : parking_details){
                System.out.println(pd1.getParkingid());
                System.out.println(pd1.getParking_location());
                System.out.println(pd1.getSlot_price());
                System.out.println(pd1.getParking_pincode());
//                System.out.println(pd1.getDate());
                System.out.println(pd1.getAvailable_slots());
                System.out.println(pd1.getTotal_slots());
                System.out.println(pd1.getBooked_slots());
                System.out.println(pd1.getStarting_time());
                System.out.println(pd1.getEnd_time());
                System.out.println(pd1.getParking_name());
                System.out.println(pd1.getMaps());
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
