package com.example.guest.openweather;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by Guest on 11/29/16.
 */
public class WeatherService {
    public static final String TAG = WeatherService.class.getSimpleName();
    public static void findWeather(String location, Callback callback) {
        OkHttpClient client = new OkHttpClient.Builder()
                .build();

        HttpUrl.Builder urlBuilder = HttpUrl.parse(Constants.API_BASE_URL).newBuilder();
        urlBuilder.addQueryParameter(Constants.YOUR_QUERY_PARAMETER, location);
        urlBuilder.addQueryParameter(Constants.API_KEY_QUERY_PARAMETER, Constants.API_KEY);
        urlBuilder.addQueryParameter("units", "imperial");
        urlBuilder.addQueryParameter("cnt", "7");
        String url = urlBuilder.build().toString();
        Log.v(TAG, url);

        Request request = new Request.Builder()
                .url(url)
                .build();

        Call call = client.newCall(request);
        call.enqueue(callback);
    }

    public ArrayList<Weather> processResults (Response response) {
        ArrayList<Weather> weatherForescasts = new ArrayList<>();

        try {
            String jsonData = response.body().string();
            if (response.isSuccessful()) {
                JSONObject weatherJSON = new JSONObject(jsonData);
                Log.v(TAG, "here" + weatherJSON.toString());
                JSONArray daysOfWeatherJSON = weatherJSON.getJSONArray("list");
                Log.v(TAG, "in days of weather " + daysOfWeatherJSON.toString());
                for (int i = 0; i < daysOfWeatherJSON.length(); i++) {
                    JSONObject dayWeatherJSON = daysOfWeatherJSON.getJSONObject(i);
                    String icon = dayWeatherJSON.getJSONArray("weather").getJSONObject(0).getString("icon");
//                    String country = dayWeatherJSON.getString("country");
                    String date = dayWeatherJSON.getString("dt");
                    String description = dayWeatherJSON.getJSONArray("weather").getJSONObject(0).getString("description");
                    double temperature = dayWeatherJSON.getJSONObject("temp").getDouble("day");
                    Weather weather = new Weather(icon, date, description, temperature);
                    weatherForescasts.add(weather);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return weatherForescasts;
    }
}
