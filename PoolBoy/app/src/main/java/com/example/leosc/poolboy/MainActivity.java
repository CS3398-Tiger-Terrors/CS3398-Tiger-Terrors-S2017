package com.example.leosc.poolboy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result;
    EditText number1, number2, number3;
    Button calculate;

    double result_num;
    double num1, num2, num3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        result = (TextView)findViewById(R.id.result);
        number1 = (EditText)findViewById(R.id.number1);
        number2 = (EditText)findViewById(R.id.number2);
        number3 = (EditText)findViewById(R.id.number3);
        calculate = (Button)findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1 = Double.parseDouble(number1.getText().toString());
                num2 = Double.parseDouble(number2.getText().toString());
                num3 = Double.parseDouble(number3.getText().toString());
                result_num = num1 * num2 * num3 * 7.5;
                result.setText(String.valueOf(result_num));
            }
        });
    }
}
