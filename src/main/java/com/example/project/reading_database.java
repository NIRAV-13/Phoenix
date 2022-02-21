package com.example.project;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.example.project.Database_connection.testing_connection;

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
    public static void main(String[] args) throws IOException {
        Userid("Sparsh");

    }
    }
