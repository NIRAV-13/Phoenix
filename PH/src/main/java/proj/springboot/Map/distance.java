//package proj.springboot.Map;
//
//import okhttp3.OkHttpClient;
//import okhttp3.Request;
//import okhttp3.Response;
//
//import java.io.IOException;
//
//public class distance {
//    public static void main(String args[]){
//        try{
//            OkHttpClient client = new OkHttpClient().newBuilder()
//                    .build();
//            Request request = new Request.Builder()
//                    .url("https://maps.googleapis.com/maps/api/distancematrix/json?origins=Current%20Location&destinations=40.659569%2C-73.933783%7C40.729029%2C-73.851524%7C40.6860072%2C-73.6334271%7C40.598566%2C-73.7527626&key=AIzaSyD9AqMr1RDHSU7I_JCsn9sfNKkgoFOKVE8")
//                    .method("GET", null)
//                    .build();
//            Response response = client.newCall(request).execute();
//            System.out.println(response);
//        }catch (Exception e){
//            System.out.println("Error");
//        }
//
//
//    }
//
//}
