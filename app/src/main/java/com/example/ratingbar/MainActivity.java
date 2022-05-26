package com.example.ratingbar;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    TextView Tvaverage;
    RatingBar Rbrating;
    Button BtnRate;
    int click_time = 0;
    float total_star = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Tvaverage = findViewById(R.id.average_user_rating);
        Rbrating = findViewById(R.id.rating_stars);
        BtnRate = findViewById(R.id.button_rate);
        Rbrating.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                if (v < 1.0f){
                    Rbrating.setRating(1.0f);
                }
                BtnRate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        float rate = Rbrating.getRating();
                        float total = total_star + rate;
                        total_star = total;
                        int clicktime = click_time + 1;
                        click_time = clicktime;
                        float average = total_star / click_time;
                        DecimalFormat f = new DecimalFormat("##.0");
                        Tvaverage.setText(f.format(average));
                    }
                });
            }
        });
    }
}