import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String API_KEY;
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        WeatherAPI weatherAPI = new WeatherAPI();
        String input;
        do {
            input = reader.readLine();
            String[] command = input.split(" ");
            switch (command[0]){
                case "SET" -> {
                    FetchApiResponse(weatherAPI,command[1]);
                }
                case "GET" -> {
                    GetWeatherDetails(weatherAPI,command[1]);
                }
            }

        }while (!input.equals("quit"));
    }

    private static void GetWeatherDetails(WeatherAPI weatherAPI, String s) {
        weatherAPI.getCityDetails(s);
    }

    private static void FetchApiResponse(WeatherAPI weatherAPI, String s) throws IOException {
        weatherAPI.FetchApi(s);
    }
}