package com.example.guest.openweather;

import org.parceler.Parcel;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Guest on 11/29/16.
 */
@Parcel
public class Weather {
    String mIcon;
    String mDate;
    String mDescription;
    double mTemperature;

    public Weather() {}


    public Weather(String icon, String date, String description, double temperature) {
        this.mIcon = icon;
        this.mDate = date;
        this.mDescription = description;
        this.mTemperature = temperature;
    }

    public String getIcon() {
        String url = "http://openweathermap.org/img/w/" + mIcon + ".png";
        return url;
    }

    public String getDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("MMMM dd, yyyy");
        Date date = new Date(Long.parseLong(mDate)*1000);
        String newDate = formatter.format(date);
        return newDate;
    }

    public String getDescription() {
        return mDescription;
    }

    public double getTemperature() {
        return mTemperature;
    }
}