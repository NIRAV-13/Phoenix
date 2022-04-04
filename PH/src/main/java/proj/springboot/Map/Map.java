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
    public static String[] Map(Integer parking_id) throws ClassNotFoundException, SQLException {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyD9AqMr1RDHSU7I_JCsn9sfNKkgoFOKVE8")
                .build();
        //tesing database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection connection = testing_connection();
        //creating statement for executing query statement
        Statement stmt1 = (Statement) connection.createStatement();
        //selecting database
        int rs2 = stmt1.executeUpdate("Use CSCI5308_14_TEST");
        ResultSet rs1 = stmt1.executeQuery("select * from slot where id ='" + parking_id +"'");
        String address = null;
        String city =null;
        while(rs1.next()) {
            direction_object doj = new direction_object();
            address = rs1.getString(5);
            city = rs1.getString(9);
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
            for(int i=0;i<location.length;i++){
                System.out.println(location[i]);
            }
            return location;

        } catch (Exception e) {
            System.out.println(e);
            return location;
        }
    }
    public static void main(String args[]) throws SQLException, ClassNotFoundException {
        Map(1);
    }
}
