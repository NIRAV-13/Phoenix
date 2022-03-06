package proj.springboot.parking;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class Database_connection {
    public static Connection testing_connection() {
        try{
            Properties pts= new Properties();
            FileInputStream input= new FileInputStream("config.properties");
            pts.load(input);
            input.close();
            String url = pts.getProperty("jdbc.url");
            String username = pts.getProperty("jdbc.user");
            String password = pts.getProperty("jdbc.password");
            Connection con= DriverManager.getConnection(url,username,password);
            return con;
        } catch (Exception e) {
            System.out.println(e);
            return null;
        }
    }
}
