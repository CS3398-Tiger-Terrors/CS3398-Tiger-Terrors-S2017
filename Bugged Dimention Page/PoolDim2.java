package com.example.nwarr.pooldimpg2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PoolDim2 extends AppCompatActivity {

    EditText ed1;
    Button b1;

    SharedPreferences sharedpreferences = getSharedPreferences(MyPref, Context.MODE_PRIVATE);
    SharedPreferences.Editor edits = sharedpreferences.edit();

    public static final String MyPref = "Pref";
    public static final String Dimen = "SavedDim";

    public float getprefs = sharedpreferences.getFloat(Dimen, 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_dim2);

        ed1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float Dim;
                String str =  ed1.getText().toString();
                Dim = Float.parseFloat(str);
                getprefs = 0;

                edits.putFloat(Dimen, Dim);

                edits.apply();
            }
        });
    }
}
