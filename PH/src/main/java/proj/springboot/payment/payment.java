package proj.springboot.payment;

import proj.springboot.parking.Parking_details;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;

import static proj.springboot.parking.Database_connection.testing_connection;

public class payment {
    public static void random_generation_number() {
        String alphanumeric = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder string_build = new StringBuilder();
        Random random_number = new Random();
        while (string_build.length() < 12) {
            int number = (int) (random_number.nextFloat() * alphanumeric.length());
            string_build.append(alphanumeric.charAt(number));
        }
        String string_int = string_build.toString();
        System.out.println(string_int);
    }
    public static void main(String args[]){
        random_generation_number();
    }
}
