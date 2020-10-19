package com.example.karentest;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class TestActivity extends AppCompatActivity {
    TextView head, question,email;
    Button yes, no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        getSupportActionBar().hide();

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {

            }
        });

        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        Log.d("karentest","Karen "+ adRequest.getContentUrl());


        head = (TextView)findViewById(R.id.header_tv);
        question = (TextView)findViewById(R.id.q_tv);
        email = (TextView)findViewById(R.id.email_tv);

        yes = (Button)findViewById(R.id.yes_btn);
        no = (Button)findViewById(R.id.no_btn);
    }

    public void YesOnClick(View v)
    {
        head.setText("Your Result:");
        question.setText("You are a Karen!");
        question.setTextColor(Color.parseColor("#E91E63"));

        email.setVisibility(View.VISIBLE);
        yes.setVisibility(View.GONE);
        no.setVisibility(View.GONE);
    }

    public void NoOnClick(View v)
    {
        head.setText("Your Result:");
        question.setText("You are not a Karen!");
        question.setTextColor(Color.parseColor("#673AB7"));
        email.setVisibility(View.VISIBLE);
        yes.setVisibility(View.GONE);
        no.setVisibility(View.GONE);
    }
}
