import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class Kanyequotes {

    public static String getKanyeQuote() {
        try {
            URL url = new URL("https://api.kanye.rest/text");
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            if (connection.getResponseCode() == 200) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                StringBuilder response = new StringBuilder();
                String line;

                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }

                reader.close();
                return response.toString();
            } else {
                return "Failed to retrieve a Kanye quote. Status code: " + connection.getResponseCode();
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "An error occurred: " + e.getMessage();
        }
    }

    public static void main(String[] args) {
        String kanyeQuote = getKanyeQuote();
        System.out.println("Kanye Quote: " + kanyeQuote);
    }
}
