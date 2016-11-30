package com.example.guest.openweather.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.guest.openweather.R;
import com.example.guest.openweather.Weather;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Guest on 11/29/16.
 */
public class DailyWeatherAdapter extends RecyclerView.Adapter<DailyWeatherAdapter.WeatherViewHolder> {
    private static final int MAX_WIDTH = 50;
    private static final int MAX_HEIGHT = 50;
    private ArrayList<Weather> mWeathers = new ArrayList<>();
    private Context mContext;

    public DailyWeatherAdapter(Context context, ArrayList<Weather> weathers) {
        mContext = context;
        mWeathers = weathers;
    }

    @Override
    public DailyWeatherAdapter.WeatherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.daily_list_item, parent, false);
        WeatherViewHolder viewHolder = new WeatherViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DailyWeatherAdapter.WeatherViewHolder holder, int position) {
        holder.bindWeather(mWeathers.get(position));
    }

    @Override
    public int getItemCount() {
        return mWeathers.size();
    }

    public class WeatherViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.weatherIcon) ImageView mWeatherIcon;
        @Bind(R.id.weatherDate) TextView mWeatherDate;
        @Bind(R.id.weatherDescription) TextView mWeatherDescription;
        @Bind(R.id.weatherTemperature) TextView mWeatherTemperature;

        private Context mContext;

        public WeatherViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindWeather(Weather weather) {
            Picasso.with(mContext)
                    .load(weather.getIcon())
                    .resize(MAX_WIDTH, MAX_HEIGHT)
                    .centerCrop()
                    .into(mWeatherIcon);
            mWeatherDate.setText(weather.getDate());
            mWeatherDescription.setText(weather.getDescription());
            mWeatherTemperature.setText("Temperature: " + weather.getTemperature()+"°F");
        }
    }
}
