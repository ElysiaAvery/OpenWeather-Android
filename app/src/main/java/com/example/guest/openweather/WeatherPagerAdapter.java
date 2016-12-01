package com.example.guest.openweather;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by Guest on 11/30/16.
 */
public class WeatherPagerAdapter extends FragmentPagerAdapter {
    private ArrayList<Weather> mWeather;

    public WeatherPagerAdapter(FragmentManager fm, ArrayList<Weather> weathers) {
        super(fm);
        mWeather = weathers;
    }

    @Override
    public Fragment getItem(int position) {
        return WeatherDetailFragment.newInstance(mWeather.get(position));
    }

    @Override
    public int getCount() {
        return mWeather.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mWeather.get(position).getDescription();
    }
}
