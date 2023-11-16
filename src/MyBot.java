import org.jibble.pircbot.*;

public class MyBot extends PircBot {
    int flag = 0;
    public MyBot() {
        this.setName("bo333");
    }
    public void weather(String channel, String sender, String message) {
        WeatherApi weatherApi = new WeatherApi();
        String weatherInfo = weatherApi.getWeather(message);
        if(weatherInfo != "Error fetching weather data." ){
            sendMessage(channel, sender + " The weather forecast for " + message + " "+ weatherInfo);
            flag = 0;
        }
        else {
            sendMessage(channel, sender + " Please enter the zip code or city name again.");
            flag = 1;
        }

    }
    public void onMessage(String channel, String sender,
                          String login, String hostname, String message) {
        if(flag == 1){
            weather(channel, sender, message);

        }

        if (message.equalsIgnoreCase("time")) {
            String time = new java.util.Date().toString();
            sendMessage(channel, sender + " : The time is now " + time);
        }

        if(message.equalsIgnoreCase("menu")){
            sendMessage(channel, sender + " : The menu options are: ");
            sendMessage(channel, sender + " : 1. Weather");
            sendMessage(channel, sender + " : 2. Kanye Quotes");
        }
        if(message.equalsIgnoreCase("weather")){
            flag = 1;
            sendMessage(channel, sender + " Please enter either a city or a zip code.");

        }
        if(message.equalsIgnoreCase("Kanye Quotes")){
            Kanyequotes kanye = new Kanyequotes();
            String kanyeQuote = kanye.getKanyeQuote();
            sendMessage(channel, sender + " Here is your quote:" + kanyeQuote);

        }
        if(message.equalsIgnoreCase("spotify")){
            sendMessage(channel, sender + " : The spotify is: ");
        }

    }



}