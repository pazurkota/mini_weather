package org.pazurkota.View;

import org.pazurkota.API.DataParser;
import org.pazurkota.Model.WeatherRoot;

public class GetData {
    private static float _lat;
    private static float _lon;

    private static final DataParser parser = DataParser.getInstance();
    private static final WeatherRoot root = parser.parseWeatherData(_lat, _lon);

    public GetData(float lat, float lon) {
        _lat = lat;
        _lon = lon;
    }
}
