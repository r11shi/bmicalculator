package com.example.bmicalculator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText etHeight, etWeight;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etHeight = findViewById(R.id.etHeight);
        etWeight = findViewById(R.id.etWeight);
        tvResult = findViewById(R.id.tvResult);

        Button btnCalculate = findViewById(R.id.btnCalculate);
        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = etHeight.getText().toString();
        String weightStr = etWeight.getText().toString();

        if(!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr) / 100; // Convert cm to meters
            float weight = Float.parseFloat(weightStr);

            float bmi = weight / (height * height);

            String result;
            if(bmi < 18.5) {
                result = "Underweight";
            } else if(bmi < 25) {
                result = "Normal";
            } else if(bmi < 30) {
                result = "Overweight";
            } else {
                result = "Obese";
            }

            tvResult.setText(String.format("BMI: %.1f\n%s", bmi, result));
        }
    }
}