package org.pazurkota;

import org.pazurkota.API.DataParser;
import org.pazurkota.Model.Geolocation;
import org.pazurkota.Model.WeatherRoot;
import org.pazurkota.View.GetData;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final DataParser parser = DataParser.getInstance();

    public static void main(String[] args) {
        try {
            Geolocation geolocation = parser.parseGeolocationData("Wroclaw");
            WeatherRoot currentWeather = parser.parseWeatherData(geolocation.lat, geolocation.lon);

            System.out.println(currentWeather.weather.getFirst().description);

            float[] getWindData = GetData.getWindData(currentWeather);

            System.out.println(getWindData[0]); // wind speed
            System.out.println(GetData.getRainData(currentWeather));
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}