package proj.springboot.Map;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class direction {
    public static void main(String args[]){
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
            Desktop.getDesktop().browse(new URI(maps));
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}
