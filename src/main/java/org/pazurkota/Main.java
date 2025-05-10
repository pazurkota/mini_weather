package org.pazurkota;

import org.pazurkota.API.ApiClient;
import org.pazurkota.Model.Geolocation;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Geolocation geolocation = ApiClient.getGeolocation("Wroclaw");

            // check if geolocation is not null
            assert geolocation != null;

            System.out.println(geolocation.lat); // get latitude
            System.out.println(geolocation.lon); // get longitude
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}