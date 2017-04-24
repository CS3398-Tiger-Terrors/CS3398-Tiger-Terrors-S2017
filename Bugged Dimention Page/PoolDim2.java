package com.example.nwarr.pooldimpg2;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class PoolDim2 extends AppCompatActivity {

    EditText ed1;
    Button b1;

    SharedPreferences sharedpreferences = getSharedPreferences(Dimen, 0);
    SharedPreferences.Editor edits = sharedpreferences.edit();

    public static final String Dimen = "SavedDim";

    String getDim = sharedpreferences.getString("SavedDim", "");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_dim2);

        ed1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.button);

        getDim =  ed1.getText().toString();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                edits.clear();
                edits.putString("SavedDim", getDim);
                edits.commit();
            }
        });
    }
}

