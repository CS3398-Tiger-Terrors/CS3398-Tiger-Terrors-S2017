package com.example.nwarr.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.TextView;

public class Results extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        ViewGroup layout = (ViewGroup) findViewById(R.id.activity_results);

        Intent intent = getIntent();
        String chlorine = intent.getStringExtra(MainActivity.EXTRA_CHLOR);
        TextView textView7 = new TextView(this);
        textView7.setTextSize(10);
        textView7.setText(chlorine);

        layout.addView(textView7);

        String ph = intent.getStringExtra(MainActivity.EXTRA_PH);
        TextView textView8 = new TextView(this);
        textView8.setTextSize(10);
        textView8.setText(ph);
        layout.addView(textView8);

        String alkalinity = intent.getStringExtra(MainActivity.EXTRA_ALK);
        TextView textView9 = new TextView(this);
        textView9.setTextSize(10);
        textView9.setText(alkalinity);
        layout.addView(textView9);

        String cyanic = intent.getStringExtra(MainActivity.EXTRA_CYAN);
        TextView textView10 = new TextView(this);
        textView10.setTextSize(10);
        textView10.setText(cyanic);
        layout.addView(textView10);

        String hardness = intent.getStringExtra(MainActivity.EXTRA_HARD);
        TextView textView11 = new TextView(this);
        textView11.setTextSize(10);
        textView11.setText(hardness);
        layout.addView(textView11);
    }

}
