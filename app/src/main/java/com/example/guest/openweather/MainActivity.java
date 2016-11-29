package com.example.guest.openweather;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @Bind(R.id.submitButton) Button mSubmitButton;
    @Bind(R.id.locationInput) EditText mLocationInput;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mSubmitButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mSubmitButton) {
            String location = mLocationInput.getText().toString();
            Intent intent = new Intent(MainActivity.this, WeatherActivity.class);
            intent.putExtra("location", location);
            startActivity(intent);
        }
    }
}
