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

    public static ArrayList<Parking_details> parking_cards() {
        try {
            ArrayList<Parking_details> parking_details = new ArrayList<>();
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
            ResultSet rs1 = stmt1.executeQuery("select * from slot");
            //retreving the value stored in database
            while(rs1.next()){
                //getting value of total initial slots available
                Parking_details pd = new Parking_details();
                if(rs1.getInt(3) >0){
                    //                pd.setDate(rs1.getDate(6));
                    pd.setParking_name(rs1.getString(8));
                    pd.setId(rs1.getInt(1));
                    pd.setTotal_slots(rs1.getInt(3));
                    int available_slots = rs1.getInt(3);
                    pd.setAvailable_slots(available_slots);
                    pd.setParking_location(rs1.getString(5));
                    pd.setParkingid(rs1.getInt(1));
                    pd.setParking_pincode(rs1.getString(9));
                    pd.setBooked_slots(rs1.getInt(2));
                    pd.setSlot_price((rs1.getInt(10)));
                    pd.setMaps(direction.direction_finder(rs1.getInt(1)));
                    parking_details.add(pd);
                }

            }
            for(Parking_details pd1 : parking_details){
                System.out.println(pd1.getParkingid());
                System.out.println(pd1.getParking_location());
                System.out.println(pd1.getSlot_price());
                System.out.println(pd1.getParking_pincode());
                System.out.println(pd1.getAvailable_slots());
                System.out.println(pd1.getTotal_slots());
                System.out.println(pd1.getBooked_slots());
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
