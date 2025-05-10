package org.pazurkota;

import org.pazurkota.API.ApiClient;
import org.pazurkota.API.DataParser;
import org.pazurkota.Model.Geolocation;
import org.pazurkota.Model.WeatherRoot;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final DataParser parser = DataParser.getInstance();

    public static void main(String[] args) {
        try {
            Geolocation geolocation = parser.parseGeolocationData("Wroclaw");
            WeatherRoot currentWeather = parser.parseWeatherData(geolocation.lat, geolocation.lon);

            System.out.println(currentWeather.weather.getFirst().description);

            // check if JSON returned precipitation, if not, show 0
            if (currentWeather.rain != null) {
                System.out.println(currentWeather.rain._1h);
            } else {
                System.out.println(0);
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}