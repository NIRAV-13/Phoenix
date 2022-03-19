package proj.springboot.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.model.GeocodingResult;

public class Map {
    public static String[] Map(){
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyD9AqMr1RDHSU7I_JCsn9sfNKkgoFOKVE8")
                .build();
        GeocodingResult[] results;
        String[] location = new String[2];
        try {
            results = GeocodingApi.geocode(context,
                        "1333 South Park St Halifax, NS B3J9K9").await();
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
        public static void main(String args[]){
        Map();
        }
    }
