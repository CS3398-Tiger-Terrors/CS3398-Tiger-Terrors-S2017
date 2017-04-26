package com.example.nwarr.pooldimpg2;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PoolDim2 extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    Button b1;

    public static final String Dimen = "SavedDim";

    SharedPreferences sharedpreferences = getSharedPreferences(Dimen, Context.MODE_PRIVATE);
    SharedPreferences.Editor edits = sharedpreferences.edit();

    String getDim = sharedpreferences.getString("SavedDim", "");
    String getLen;
    String getWid;
    String getDep;
    String getSha;

    double L, W, D, M, Dimension;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_dim2);

        sharedpreferences = PreferenceManager.getDefaultSharedPreferences(this.getBaseContext());

        ed1=(EditText)findViewById(R.id.editText);
        ed2= (EditText)findViewById(R.id.editText2);
        ed3= (EditText)findViewById(R.id.editText3);
        ed4= (EditText)findViewById(R.id.editText4);
        b1=(Button)findViewById(R.id.button);

        getLen =  ed3.getText().toString();
        getWid =  ed2.getText().toString();
        getDep =  ed1.getText().toString();
        getSha =  ed4.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                L = Double.parseDouble(getLen);
                W = Double.parseDouble(getWid);
                D = Double.parseDouble(getDep);
                switch (getSha) {
                    case "rectangle":
                        M = 7.5;
                        break;
                    case "oval":
                        M = 6.7;
                        break;
                    case "round":
                        M = 5.9;
                        break;
                    default:
                        M = 1;
                }

                Dimension = L * W * D * M;
                getDim = Double.toString(Dimension);
            }
        });

        edits.clear();
        edits.putString("SavedDim", getDim);
        edits.apply();
    }
}