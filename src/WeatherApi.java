import java.io.IOException;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.net.HttpURLConnection;
import java.net.URL;
import java.io.InputStreamReader;
import io.github.cdimascio.dotenv.Dotenv;


public class WeatherApi {
    private double lat;
    private double lon;
    private String city = "null";
    private String zip= "null";
    private String appid;
    public WeatherApi() {
        // Load the .env file
        Dotenv dotenv = Dotenv.configure().load();

        // Retrieve the value of WEATHER_API_KEY from .env
        appid = dotenv.get("WEATHER_API_KEY");
    }


    public boolean containsNumber(String s){
        for(int i = 0; i < s.length(); i++){
            if(Character.isDigit(s.charAt(i))){
                return true;
            }
        }
        return false;
    }
    public void setziporcity(String ziporcity){
        if(containsNumber(ziporcity)){
            zip = ziporcity;
        }
        else{
            city = ziporcity;
        }
    }
    public void getLatLonByCity(String cityName) {
        try {
            String apiUrl = "https://api.openweathermap.org/geo/1.0/direct?q=" + cityName + "&limit=1&appid=" + appid;

            URL url = new URL(apiUrl);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonArray().get(0).getAsJsonObject();

             lat = jsonResponse.get("lat").getAsDouble();
             lon = jsonResponse.get("lon").getAsDouble();

            System.out.println("Latitude: " + lat);
            System.out.println("Longitude: " + lon);

            connection.disconnect();
        } catch (IOException e) {
            e.printStackTrace();

            System.err.println("Error fetching data.");
        }
    }

    public String getWeather(String mess) {
        String url;
        try {
            setziporcity(mess);
            if (zip.equals("null")) {
                getLatLonByCity(city);
                url = "https://api.openweathermap.org/data/2.5/weather?lat=" + lat + "&lon=" + lon + "&appid=" + appid;
            } else {
                url = "https://api.openweathermap.org/data/2.5/weather?zip=" + zip + "&appid=" + appid;
            }

            URL weatherURL = new URL(url);
            HttpURLConnection connection = (HttpURLConnection) weatherURL.openConnection();

            InputStreamReader reader = new InputStreamReader(connection.getInputStream());
            JsonObject jsonResponse = JsonParser.parseReader(reader).getAsJsonObject();

            double temperature = jsonResponse.getAsJsonObject("main").get("temp").getAsDouble();
            String description = jsonResponse.getAsJsonArray("weather").get(0).getAsJsonObject().get("description").getAsString();

            connection.disconnect();
            temperature = ((((temperature - 273.15) * 9 )/5)+32);
            int temp = (int) Math.round(temperature);

            return "Temperature: " + temp + "°F, Description: " + description;
        } catch (IOException e) {
            e.printStackTrace();
            return "Error fetching weather data.";
        }
    }


}


