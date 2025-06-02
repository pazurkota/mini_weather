package org.pazurkota;

import org.pazurkota.API.DataParser;
import org.pazurkota.Model.Geolocation;
import org.pazurkota.Model.WeatherRoot;
import org.pazurkota.View.GetData;
import org.pazurkota.View.PrintData;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final DataParser parser = DataParser.getInstance();

    public static void main(String[] args) {
        try {
            Geolocation geolocation = parser.parseGeolocationData("New York");

            PrintData data = new PrintData(geolocation.lat, geolocation.lon);

            data.printCurrentWeather();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}