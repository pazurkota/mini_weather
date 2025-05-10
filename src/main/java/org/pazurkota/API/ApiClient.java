package org.pazurkota.API;

import com.google.gson.Gson;
import jdk.jshell.spi.ExecutionControl.NotImplementedException;
import org.pazurkota.Model.Geolocation;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiClient {
    private final static HttpClient CLIENT = HttpClient.newHttpClient();
    private final static String BASE_URL = "https://api.openweathermap.org";
    private final static String API_KEY = ApiKeyHandler.readKeyFromJsonFile();

    public static String getWeatherData(float lat, float lon) throws IOException, InterruptedException, NotImplementedException {
        throw new NotImplementedException("This feature has been not implemented yet");
    }

    public static Geolocation getGeolocation(String cityName) throws IOException, InterruptedException {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(BASE_URL + "/geo/1.0/direct?q=" + cityName + "&limit=1&appid=" + API_KEY))
                .GET()
                .build();

        HttpResponse<String> response = CLIENT.send(request, HttpResponse.BodyHandlers.ofString());

        if (response.statusCode() == 200) {
            Geolocation[] geolocations = new Gson().fromJson(response.body(), Geolocation[].class);
            if (geolocations.length > 0) {
                return geolocations[0];
            }
        }
        return null;
    }
}
