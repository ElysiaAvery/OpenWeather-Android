package com.example.guest.openweather;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class WeatherDetailActivity extends AppCompatActivity {
    @Bind(R.id.viewPager) ViewPager mPageViewer;
    private WeatherPagerAdapter adapterViewPager;
    ArrayList <Weather> mWeather = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_detail);
        ButterKnife.bind(this);

        mWeather = Parcels.unwrap(getIntent().getParcelableExtra("weather"));
        int startingPosition = getIntent().getIntExtra("position", 0);

        adapterViewPager = new WeatherPagerAdapter(getSupportFragmentManager(), mWeather);
        mPageViewer.setAdapter(adapterViewPager);
        mPageViewer.setCurrentItem(startingPosition);
    }
}
