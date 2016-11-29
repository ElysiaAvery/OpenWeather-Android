package com.example.guest.openweather;

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
        return mIcon;
    }

    public String getDate() {
        return mDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public double getTemperature() {
        return mTemperature;
    }
}