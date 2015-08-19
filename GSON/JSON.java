/*
 * Vessel schedule display page
 */
package com.twizted.GSON;

import com.google.gson.Gson;
import com.twizted.WeatherQuest.Current;
import com.twizted.WeatherQuest.Forecast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Weather fetching and parsing class.
 *
 * @author Ian Weeks
 */
public class JSON
{
    private Gson gson;

    public JSON()
    {
        gson = new Gson();
    }

    /**
     * Get the current weather for a given latitude and longitude.
     *
     * @param lat The latitude to be used.
     * @param lon The longitude to be used.
     * @return The current weather for the given latitude and longitude.
     */
    public Current fetchCurrent(double lat, double lon)
    {
        String apiUrl = "http://weatherquest.co.uk/includes/global/customers/James-Fisher/Marine/Feeds/" +
                "LiveFeedJSON.php?Key=U6u4mte4v$^EQK8!jBBJ&Lat=" + lat + "&Lon=" + lon;
        try
        {
            return gson.fromJson(fetch(apiUrl), Current.class);
        }catch (Exception e)
        {
            return null;
        }
    }

    /**
     * Get the forecast weather for a given latitude and longitude.
     *
     * @param lat The latitude to be used.
     * @param lon The longitude to be used.
     * @return The forecast weather for the given latitude and longitude.
     */
    @SuppressWarnings("unused")
    public Forecast fetchForecast(double lat, double lon)
    {
        //This method is not used at the moment but could be at a later stage.

        String apiUrl = "http://weatherquest.co.uk/includes/global/customers/James-Fisher/Marine/Feeds/" +
                "1-2DayForecastFeedJSON.php?Key=U6u4mte4v$^EQK8!jBBJ&Lat=" + lat + "&Lon=" + lon;
        try
        {
            return gson.fromJson(fetch(apiUrl), Forecast.class);
        } catch (IOException e)
        {
            return null;
        }
    }

    /**
     * Generic fetch method used by the above to get the weather.
     *
     * @param weatherURL The URL to be used.
     * @return A JSON string containing the weather information.
     * @throws IOException If any IO errors occur.
     */
    private String fetch(String weatherURL) throws IOException
    {
        String json = "";
        URL url = new URL(weatherURL);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setDoOutput(true);
        try (BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream())))
        {
            String line;
            while ((line = in.readLine()) != null)
            {
                json += line;
            }
        }
        return json.trim();
    }
}
