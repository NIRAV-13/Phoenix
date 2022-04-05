package proj.springboot.parking;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database_connection {
    public static Connection testing_connection() {
        try{
//            Properties pts= new Properties();
//            String dir = System.getProperty("user.dir");
//            System.out.println(dir);
//            FileInputStream input= new FileInputStream("config.properties");
//            pts.load(input);
//            input.close();
            String url = "jdbc:mysql://db-5308.cs.dal.ca/CSCI5308_14_TEST";
            String username = "CSCI5308_14_TEST_USER";
            String password = "eehoo5ohchoh6aeL";
            Connection con= DriverManager.getConnection(url,username,password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
    public static void main(String args[]){
        testing_connection();
    }
}
