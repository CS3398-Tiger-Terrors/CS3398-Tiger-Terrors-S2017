package com.example.nwarr.myfirstapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
//import android.view.ViewGroup;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity
{

    public final static String EXTRA_CHLOR = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_PH = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_ALK = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_CYAN = "com.example.myfirstapp.MESSAGE";
    public final static String EXTRA_HARD = "com.example.myfirstapp.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ViewGroup layout = (ViewGroup) findViewById(R.id.activity_main);

        //Intent intent = getIntent();
    }

    public void CALKULAT(View view)
    {
        Intent intent = new Intent(this, Results.class);

        EditText editTextChlor = (EditText) findViewById(R.id.chlorText);

        String chlorine = editTextChlor.getText().toString();
        intent.putExtra(EXTRA_CHLOR, chlorine);

        Intent intent1 = new Intent(this, Results.class);

        EditText editTextPh = (EditText) findViewById(R.id.phText);

        String ph = editTextPh.getText().toString();
        intent.putExtra(EXTRA_PH, ph);

        Intent intent2 = new Intent(this, Results.class);

        EditText editTextAlk = (EditText) findViewById(R.id.alkText);

        String alkalinity = editTextAlk.getText().toString();
        intent.putExtra(EXTRA_ALK, alkalinity);

        Intent intent3 = new Intent(this, Results.class);

        EditText editTextCyan = (EditText) findViewById(R.id.cyanText);

        String cyanic = editTextCyan.getText().toString();
        intent.putExtra(EXTRA_CYAN, cyanic);

        Intent intent4 = new Intent(this, Results.class);

        EditText editTextHard = (EditText) findViewById(R.id.hardText);

        String hardness = editTextHard.getText().toString();
        intent.putExtra(EXTRA_HARD, hardness);

        startActivity(intent);
        startActivity(intent1);
        startActivity(intent2);
        startActivity(intent3);
        startActivity(intent4);
    }
}
