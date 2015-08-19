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

    public Current fetchCurrent(double lat, double lon) throws IOException
    {
        String apiUrl = "http://weatherquest.co.uk/includes/global/customers/James-Fisher/Marine/Feeds/LiveFeedJSON.php?Key=U6u4mte4v$^EQK8!jBBJ&Lat=" + lat + "&Lon=" + lon;
        Current result;
        try
        {
            return gson.fromJson(fetch(apiUrl), Current.class);
        }catch (Exception e)
        {
            return null;
        }
    }

    public Forecast fetchForecast(double lat, double lon)throws IOException
    {
        String apiUrl = "http://weatherquest.co.uk/includes/global/customers/James-Fisher/Marine/Feeds/1-2DayForecastFeedJSON.php?Key=U6u4mte4v$^EQK8!jBBJ&Lat=" + lat + "&Lon=" + lon;
        return gson.fromJson(fetch(apiUrl), Forecast.class);
    }

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
