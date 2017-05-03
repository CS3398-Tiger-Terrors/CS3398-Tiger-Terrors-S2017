package com.example.ponno.johnsfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    public Button nextButton;
    public void init () {

        nextButton = (Button)findViewById(R.id.chlorine);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent nextPage = new Intent (MainActivity.this, ResultsActivity.class);
                getIntent().putExtra("chlorine", 30);

                startActivity(nextPage);
            }
        });

    }

    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

    }


}
