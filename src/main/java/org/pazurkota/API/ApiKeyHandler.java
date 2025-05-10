package org.pazurkota.API;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.nio.file.Path;
import java.nio.file.Paths;

public class ApiKeyHandler {
    private static final String USER_HOME = System.getProperty("user.home");
    private static final Path DOCUMENT_PATH = Paths.get(USER_HOME, "Documents", "mini_weather_apikey.json");

    private static final Gson GSON = new Gson();

    public static void writeKeyToJsonFile(String key) {
        try (FileWriter writer = new FileWriter(DOCUMENT_PATH.toString())) {
            GSON.toJson(key, writer);
            System.out.println("Saved to file: " + DOCUMENT_PATH);
        } catch (IOException e) {
            System.out.println("Error occurred while executing ApiKeyHandler.writeKeyJsonFromFile()");
            e.printStackTrace();
        }
    }

    public static String readKeyFromJsonFile() {
        try (FileReader reader = new FileReader(DOCUMENT_PATH.toString())) {
            return GSON.fromJson(reader, String.class);
        } catch (IOException e) {
            System.out.println("Error occurred while executing ApiKeyHandler.readKeyJsonFromFile()");
            e.printStackTrace();
            return null;
        }
    }
}