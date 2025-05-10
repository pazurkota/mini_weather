package org.pazurkota;

import org.pazurkota.API.ApiClient;
import org.pazurkota.API.DataParser;
import org.pazurkota.Model.Geolocation;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    private static final DataParser parser = DataParser.getInstance();

    public static void main(String[] args) {
        try {
            Geolocation geolocation = parser.parseGeolocationData("Wroclaw");

            // print both latitude and longitude
            System.out.println(geolocation.lat);
            System.out.println(geolocation.lon);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}