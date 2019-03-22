package sda.lukaszs.weatherfx.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import sda.lukaszs.weatherfx.Model.Weather;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

public class WeatherService {
    private final String apiURL = "http://api.apixu.com/v1/current.json?key=9889be10aad4447183a115547191003&lang=pl&q=";
    private static WeatherService ourInstance = new WeatherService();
    public static WeatherService getInstance() {
        return ourInstance;
    }

    private WeatherService() { }

    public Weather getWeatherAt(String cityName) {
        Weather weather = null;
        ObjectMapper mapper = new ObjectMapper();
        try {
            URL url = new URL(apiURL + URLEncoder.encode(cityName,"UTF-8"));
            weather = mapper.readValue(url, Weather.class);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return weather;
    }
}
