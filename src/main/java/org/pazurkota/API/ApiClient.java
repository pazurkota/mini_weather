package org.pazurkota.API;

import jdk.jshell.spi.ExecutionControl.NotImplementedException;

import java.io.IOException;
import java.net.http.HttpClient;

public class ApiClient {
    private final static HttpClient CLIENT = HttpClient.newHttpClient();
    private final static String BASE_URL = "https://api.openweathermap.org/data/2.5";

    public static String getWeatherData(float lat, float lon) throws IOException, InterruptedException, NotImplementedException {
        throw new NotImplementedException("This feature has been not implemented yet");
    }

    public static Integer[] getGeolocation(String cityName) throws IOException, InterruptedException, NotImplementedException {
        throw new NotImplementedException("This feature has been not implemented yet");
    }
}
