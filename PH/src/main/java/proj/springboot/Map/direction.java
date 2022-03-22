package proj.springboot.Map;

import java.awt.*;
import java.net.URI;
import java.sql.SQLException;

public class direction {
    public static String direction_finder() throws SQLException, ClassNotFoundException {
        String lat="";
        String lng="";
        String[] location_get = Map.Map();
        for(int i=0;i<1;i++){
            lat = location_get[i];
            lng = location_get[i+1];
        }
        try {
            System.out.println(lat);
            System.out.println(lng);
            String v = "Test";
            String maps =String.format("http://maps.google.com/maps?saddr=Current"+"%%20Location&daddr=%s,%s",lat,lng);
            System.out.println(maps);
            return maps;
//            Desktop.getDesktop().browse(new URI(maps));
        } catch (Exception e) {
            System.out.println(e);
        }
        return lat;
    }

}
