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
                "Current temperature is " + weather.main.temp + "°C, but feels like " + weather.main.feels_like + "°C\n\n";

        data += printWindData();

        System.out.println(data);
    }

    public String printWindData() {
        float[] data = GetData.getWindData(weather);

        String str = "";
        str += "Current wind speed: " + data[0] + "\n";
        str += "Current wind degree: " + data[1] + "\n";
        str += "Current wind gusts: " + data[2] + "\n";

        return str;
    }
}
