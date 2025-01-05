import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

public class WeatherAPI {
    String link;
    RedisCache redis;
    public WeatherAPI(){
        redis = new RedisCache();
    }
    public void FetchApi(String CityName) throws IOException {
        URL url = URI.create(link+Main.API_KEY).toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        if (connection.getResponseCode() == 200){
            StringBuilder builder = new StringBuilder();
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String input;
            while ((input = reader.readLine()) != null){
                builder.append(input);
            }
            redis.addCityDetails(CityName,builder.toString());
        }
        connection.disconnect();
    }
    public String getCityDetails(String CityName){
        return redis.getCityDetails(CityName);
    }
}
