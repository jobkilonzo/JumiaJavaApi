import org.json.JSONArray;
import org.json.JSONObject;

import java.net.*;
import java.io.*;
public class Api{
    public static void main(String args[]){
        String urlString = "http://127.0.0.1:5001/api/laptops/laptops";

        try{
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            if (connection.getResponseCode() == 200) {
                InputStream im = connection.getInputStream();
                StringBuffer sb = new StringBuffer();
                BufferedReader br = new BufferedReader(new InputStreamReader(im));
                String line = br.readLine();

                while(line!=null){
                    //System.out.println(line);
                    sb.append(line);
                    line = br.readLine();
                }


                System.out.println(sb);
                JSONArray array = new JSONArray(sb.toString());

                for (int i=0; i < array.length(); i++) {
                    JSONObject object = array.getJSONObject(i);
                    String brand = object.getString("brand");
                    String name = object.getString("name");
                    String price = object.getString("price");
                    System.out.println(brand + " " + name + " " + price);
                }
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
