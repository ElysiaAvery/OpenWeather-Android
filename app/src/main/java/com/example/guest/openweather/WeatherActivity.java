package com.example.guest.openweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class WeatherActivity extends AppCompatActivity {
    public static final String TAG = WeatherActivity.class.getSimpleName();
    @Bind(R.id.recyclerView) RecyclerView mRecyclerView;
    @Bind(R.id.listView) ListView mListView;

    public ArrayList<Weather> mWeathers = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        getWeather(location);
    }

    protected void getWeather(String location) {
        final WeatherService weatherService = new WeatherService();
        weatherService.findWeather(location, new Callback() {

            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }
            @Override
            public void onResponse(Call call, Response response) {
              mWeathers = weatherService.processResults(response);
                WeatherActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String [] weatherDays = new String[mWeathers.size()];
                        for (int i = 0; i < weatherDays.length; i++) {
                            weatherDays[i] = mWeathers.get(i).getIcon();
                        }
                        ArrayAdapter adapter = new ArrayAdapter(WeatherActivity.this,
                                android.R.layout.simple_list_item_1, weatherDays);
                        mListView.setAdapter(adapter);

                        for (Weather weather : mWeathers) {
                            Log.d(TAG, "date: " + weather.getDescription());
                        }
                    }
                });
            }
        });
    }
}
