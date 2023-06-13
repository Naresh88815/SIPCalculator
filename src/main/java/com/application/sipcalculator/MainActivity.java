package com.application.sipcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.slider.Slider;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {
    //    private TextInputLayout investment,rate,time;
    private EditText investmentEdit, rateEdit, timeEdit;
    private Slider investmentSlider, rateSlider, timeSlider;

    private TextView totalReturnValue, totalInvestmentValue;

    private Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        investment=findViewById(R.id.investment);
        investmentEdit = findViewById(R.id.investmentEdit);
        investmentSlider = findViewById(R.id.investmentSlider);

//        rate=findViewById(R.id.rate);
        rateEdit = findViewById(R.id.rateEdit);
        rateSlider = findViewById(R.id.rateSlider);

//        time=findViewById(R.id.time);
        timeEdit = findViewById(R.id.timeEdit);
        timeSlider = findViewById(R.id.timeSlider);

        calculateBtn = findViewById(R.id.calculateBtn);

        totalReturnValue = findViewById(R.id.totalReturnValue);
        totalInvestmentValue = findViewById(R.id.totalInvestmentValue);

        investmentSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int intValue = (int) value;
                investmentEdit.setText(String.valueOf(intValue));
            }
        });


        rateSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int intValue=(int) value;
                rateEdit.setText(String.valueOf(intValue));
            }
        });

        timeSlider.addOnChangeListener(new Slider.OnChangeListener() {
            @Override
            public void onValueChange(@NonNull Slider slider, float value, boolean fromUser) {
                int intValue=(int) value;
                timeEdit.setText(String.valueOf(intValue));
            }
        });



        investmentEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    float value = Float.parseFloat(s.toString());
                    investmentSlider.setValue(value);
                }

                // Set the cursor position to the end of the text
                investmentEdit.setSelection(investmentEdit.getText().length());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int after, int count) {
                String inputText = investmentEdit.getText().toString();
                if (inputText != null && !inputText.isEmpty()) {
                    try {
                        // Create the value limit filter with desired limits
                        ValueLimitFilter valueLimitFilter = new ValueLimitFilter(1, 100000);
//
                        // Set the value limit filter as the filter for the EditText
                        investmentEdit.setFilters(new InputFilter[]{valueLimitFilter});

                        float investmentValue = Float.parseFloat(inputText);
                        investmentSlider.setValue(investmentValue);
//                        if (investmentValue >= 1 && investmentValue <= 100000) {
//
//                        } else {
//                            Toast.makeText(MainActivity.this, "Please enter a value between 1 and 100000", Toast.LENGTH_SHORT).show();
//                        }
                    } catch (NumberFormatException e) {
                        // Handle invalid input format (e.g., non-numeric characters)
                        Toast.makeText(MainActivity.this, "Invalid input format", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle empty input
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                }
            }


        });



        rateEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = rateEdit.getText().toString();
                if (inputText != null && !inputText.isEmpty()) {
                    try {
                        // Create the value limit filter with desired limits
                        ValueLimitFilter valueLimitFilter = new ValueLimitFilter(1, 20);

                        // Set the value limit filter as the filter for the EditText
                        rateEdit.setFilters(new InputFilter[]{valueLimitFilter});

                        float rateValue = Float.parseFloat(String.valueOf(s));
                        rateSlider.setValue(rateValue);
//                        if (rateValue >= 1 && rateValue <= 20) {
//
//                        } else {
//                            Toast.makeText(MainActivity.this, "Please enter the rate between 1 and 20 ", Toast.LENGTH_SHORT).show();
//                        }
                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input format", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle empty input
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    float value = Float.parseFloat(s.toString());
                    rateSlider.setValue(value);
                }

                // Set the cursor position to the end of the text
                rateEdit.setSelection(rateEdit.getText().length());
            }
        });


        timeEdit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String inputText = timeEdit.getText().toString();
                if (inputText != null && !inputText.isEmpty()) {
                    try {
                        // Create the value limit filter with desired limits
                        ValueLimitFilter valueLimitFilter = new ValueLimitFilter(1, 50);

                        // Set the value limit filter as the filter for the EditText
                        timeEdit.setFilters(new InputFilter[]{valueLimitFilter});

                        float timeValue = Float.parseFloat(s.toString());
                        timeSlider.setValue(timeValue);
//                        if (timeValue >= 1 && timeValue <= 50) {
//
//                        } else {
//                            Toast.makeText(MainActivity.this, "Please enter the time between 1 and 50", Toast.LENGTH_SHORT).show();
//                        }

                    } catch (NumberFormatException e) {
                        Toast.makeText(MainActivity.this, "Invalid input format", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    // Handle empty input
                    Toast.makeText(MainActivity.this, "Please enter a value", Toast.LENGTH_SHORT).show();
                }
            }


            @Override
            public void afterTextChanged(Editable s) {
                if (!s.toString().isEmpty()) {
                    float value = Float.parseFloat(s.toString());
                    timeSlider.setValue(value);
                }

                // Set the cursor position to the end of the text
                timeEdit.setSelection(timeEdit.getText().length());
            }
        });


        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input1=String.valueOf(investmentEdit);
                String input2=String.valueOf(rateEdit);
                String input3=String.valueOf(timeEdit);

                if (input1!=null && !input1.isEmpty() && input2!=null && !input2.isEmpty() && input3!=null && !input3.isEmpty() ) {

                    try {
                        double investment = Double.parseDouble(investmentEdit.getText().toString());
                        double rate = Double.parseDouble(rateEdit.getText().toString());
                        float timeInYears = Float.parseFloat(timeEdit.getText().toString());

                        double monthlyRate = rate / 100 / 12.0;
                        int numberOfPeriods = (int) (12 * timeInYears);

                        double result = investment * (Math.pow(1 + monthlyRate, numberOfPeriods) - 1) * (1 + monthlyRate) / monthlyRate;


                        DecimalFormat df = new DecimalFormat("#.##");
                        String formattedResult = df.format(result);

                        double investedAmt = investment * numberOfPeriods;
                        DecimalFormat iv = new DecimalFormat("#.##");
                        String investedAmount = iv.format(investedAmt);

                        System.out.println("Formatted result: " + formattedResult);

                        totalReturnValue.setText(formattedResult);
                        totalInvestmentValue.setText(investedAmount);
                    }
                    catch (NumberFormatException e){
                        Toast.makeText(MainActivity.this, "Invalid input format", Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(MainActivity.this, "Please enter values in all the fields", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

}