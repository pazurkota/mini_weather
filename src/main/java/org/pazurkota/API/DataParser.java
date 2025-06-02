package org.pazurkota.API;

import com.google.gson.Gson;
import org.pazurkota.Model.Geolocation;
import org.pazurkota.Model.WeatherRoot;

public class DataParser {
    private static volatile DataParser instance = null;

    private DataParser() {
        if (instance != null) {
            throw new RuntimeException("Not allowed! Use getInstance() instead");
        }
    }

    public static DataParser getInstance() {
        if (instance == null) {
            synchronized (DataParser.class) {
                if (instance == null) {
                    instance = new DataParser();
                }
            }
        }

        return instance;
    }

    public WeatherRoot parseWeatherData(float lat, float lon) {
        try {
            String data = ApiClient.getWeatherData(lat, lon);

            return new Gson().fromJson(data, WeatherRoot.class);
        } catch (Exception e) {
            e.printStackTrace();

            return null;
        }
    }

    public Geolocation parseGeolocationData(String cityName) {
        try {
            String data = ApiClient.getGeolocation(cityName.replaceAll("\\s+", "_"));

            Geolocation[] geolocations = new Gson().fromJson(data, Geolocation[].class);

            if (geolocations.length > 0) {
                return geolocations[0];
            }

            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
