package org.pazurkota.View;

import org.pazurkota.API.DataParser;
import org.pazurkota.Model.WeatherRoot;

public class PrintData {

    private final DataParser parser = DataParser.getInstance();
    private WeatherRoot weather;

    public PrintData(float lat, float lon) {
        weather = parser.parseWeatherData(lat, lon);
    }

    public void printCurrentWeather() {
        String data = "Current weather for " + weather.name + " is " + weather.weather.getFirst().description + ".\n" +
                "Current temperature is " + weather.main.temp + "°C, but feels like " + weather.main.feels_like + "°C";

        System.out.println(data);
    }
}
