package org.pazurkota.View;

import org.pazurkota.API.DataParser;
import org.pazurkota.Model.WeatherRoot;

import java.util.Optional;

// This class has been created to handle some of the weather data
// If API doesn't return some data, this class handles that
public class GetData {
    /// Returns table with the following data order:
    /// @return float[] {windSpeed, windDegree, windGust}
    public static float[] getWindData(WeatherRoot root) {
        float windSpeed = 0f;
        int windDegree = 0;
        float windGust = 0f;

        if(root.wind != null) {
            windSpeed = root.wind.speed;
            windDegree = root.wind.deg;
            windGust = root.wind.gust;
        }

        return new float[] {windSpeed, windDegree, windGust};
    }

    public static int getCloudsData(WeatherRoot root) {
        if (root.clouds != null) {
            return root.clouds.all;
        }

        return 0;
    }

    public static float getRainData(WeatherRoot root) {
        if (root.rain != null) {
            return root.rain._1h;
        }

        return 0f;
    }

    public static float getSnowData(WeatherRoot root) {
        if (root.snow != null) {
            return root.snow._1h;
        }

        return 0f;
    }
}
