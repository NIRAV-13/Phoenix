package proj.springboot.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;
import proj.springboot.parking.Parking_details;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static proj.springboot.parking.Database_connection.testing_connection;

public class Map {
    public static String[] Map() throws ClassNotFoundException, SQLException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyD9AqMr1RDHSU7I_JCsn9sfNKkgoFOKVE8")
                .build();
        //tesing database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = testing_connection();
        //creating statement for executing query statement
        Statement stmt1 = (Statement) connection.createStatement();
        //selecting database
        int rs2 = stmt1.executeUpdate("Use user");
        ResultSet rs1 = stmt1.executeQuery("select * from user where email ='sparsh1176@gmail.com'");
        String address = null;
        String city =null;
        while(rs1.next()) {
            address = rs1.getString(7);
            city = rs1.getString(2);
        }
        System.out.println(city);
        System.out.println(address);
        GeocodingResult[] results;
        String[] location = new String[2];
        try {
            results = GeocodingApi.geocode(context,
                    address).await();
            Gson gson = new GsonBuilder().setPrettyPrinting().create();
            location[0]=gson.toJson(results[0].geometry.location.lat);
            location[1]=gson.toJson(results[0].geometry.location.lng);
//            for(int i=0;i<location.length;i++){
//                System.out.println(location[i]);
//            }
            return location;

        } catch (Exception e) {
            System.out.println(e);
            return location;
        }
        }
        public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Map();
        }
    }
