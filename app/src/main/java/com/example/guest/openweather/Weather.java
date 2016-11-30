package com.example.guest.openweather;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Guest on 11/29/16.
 */
public class Weather {
//    private String mName;
//    private String mCountry;
    private String mIcon;
    private String mDate;
    private String mDescription;
    private double mTemperature;


    public Weather(String icon, String date, String description, double temperature) {
//        this.mName = name;
        this.mIcon = icon;
        this.mDate = date;
        this.mDescription = description;
        this.mTemperature = temperature;
    }

//    public String getName() {
//        return mName;
//    }

    public String getIcon() {
        String url = "http://openweathermap.org/img/w/" + mIcon + ".png";
        return url;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
        Date date = new Date(Long.parseLong(mDate)*1000);
        mDate = formatter.format(date);
        return mDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public double getTemperature() {
        return mTemperature;
    }
}