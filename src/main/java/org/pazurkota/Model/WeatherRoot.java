package org.pazurkota.Model;

import org.pazurkota.Model.WeatherModels.*;
import java.util.ArrayList;

public class WeatherRoot {
    public ArrayList<Weather> weather;
    public String base;
    public Main main;
    public int visibility;
    public Wind wind;
    public Rain rain;
    public Snow snow;
    public Clouds clouds;
    public int dt;
    public Sys sys;
    public int timezone;
    public int id;
    public int cod;
}
