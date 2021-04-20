package com.example.converter;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.ArrayRes;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    //declaring variables
    EditText operand1EditText;
    TextView resultTextView, resultTextView2, resultTextView3 ;
    TextView resultTV, resultTextV2, resultTextV3;
    ImageButton btnLength, btnTemp, btnWeight;
    Spinner unitSelector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //defining variables
        operand1EditText = findViewById(R.id.operand1EditText);

        resultTextView = findViewById(R.id.resultTextView);
        resultTextView2 = findViewById(R.id.resultTextView2);
        resultTextView3 = findViewById(R.id.resultTextView3);

        resultTV = findViewById(R.id.resultTV);
        resultTextV2 = findViewById(R.id.resultTextV2);
        resultTextV3 = findViewById(R.id.resultTextV3);

        btnLength = findViewById(R.id.btnLength);
        btnTemp = findViewById(R.id.btnTemp);
        btnWeight = findViewById(R.id.btnWeight);
        unitSelector = findViewById(R.id.unitSelector);
        //Strings for spinner
        String[] items = new String[]{"Metre", "Celsius", "Kilogram"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitSelector.setAdapter(adapter);

        //buttons calling the functions for unit conversions
        btnLength.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                lengthConvert();
            }
        }
        );

        btnTemp.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View v)
            {
                tempConvert();
            }
        }
        );

        btnWeight.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v)
                {
                    weightConvert();
                }
            }
        );



    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    //Length conversion try block functionality
    public void lengthConvert()
    {
        try
        {

            if (unitSelector.getSelectedItem().toString() == "Metre")
            {

                double input = Double.parseDouble(operand1EditText.getText().toString());

                double cm = input * 100;
                double inch = input * 39.37;
                double foot = input * 3.281;
                //Simple equations for length
                resultTV.setText(String.format("%.2f", cm));
                resultTextV2.setText(String.format("%.2f", inch));
                resultTextV3.setText(String.format("%.2f", foot));
                resultTextView.setText("Centimeter");
                resultTextView2.setText("Inches");
                resultTextView3.setText("Feet");

            } else {

                Toast.makeText(this, "Incorrect Button", Toast.LENGTH_LONG).show();
            }

        } catch (Exception a) {

            Toast.makeText(this, "Incorrect Value, please enter an integer", Toast.LENGTH_LONG).show();
        }
    }
    //Temperature conversion try block functionality
    public void tempConvert()
    {
        try
        {

            if (unitSelector.getSelectedItem().toString() == "Celsius")
            {
                double input = Double.parseDouble(operand1EditText.getText().toString());
                //Simple equations for Temp
                double fahrenheit = (input * (9/5))+32;
                double kelvin = input +273.15;

                resultTV.setText(String.format("%.2f", fahrenheit));
                resultTextV2.setText(String.format("%.2f", kelvin));
                resultTextV3.setText("");
                resultTextView.setText("Fahrenheit");
                resultTextView2.setText("Kelvin");
                resultTextView3.setText("");

            } else
                {
                Toast.makeText(this, "Incorrect Button", Toast.LENGTH_LONG).show();
                }

        } catch (Exception a)
            {
            Toast.makeText(this, "Incorrect Value, please enter an integer", Toast.LENGTH_LONG).show();
            }
    }
    //Weight conversion try block functionality
    public void weightConvert()
    {
        try
        {

            if (unitSelector.getSelectedItem().toString() == "Kilogram")
            {

                double input = Double.parseDouble(operand1EditText.getText().toString());
                //Simple equations for weight
                double gram = input *1000;
                double ounce = input *35.274;
                double pound = input * 2.205;

                resultTV.setText(String.format("%.2f", gram));
                resultTextV2.setText(String.format("%.2f", ounce));
                resultTextV3.setText(String.format("%.2f", pound));
                resultTextView.setText("Grams");

                resultTextView2.setText("Ounces");

                resultTextView3.setText("Pounds");


            } else

            {
                Toast.makeText(this, "Incorrect Button", Toast.LENGTH_LONG).show();
            }

        } catch (Exception a)
            {
            Toast.makeText(this, "Incorrect Value, please enter an integer", Toast.LENGTH_LONG).show();
            }
    }


}


/*


    public void divideClick(View view) {
        Toast.makeText(this, "Click to divide", Toast.LENGTH_SHORT).show();
        double result = Double.parseDouble(operand1EditText.getText().toString()) / Double.parseDouble(operand2EditText.getText().toString());
        resultTextView.setText(Double.toString(result));
    }

    public void multiplyClick(View view) {
        Toast.makeText(this, "Click to multiply", Toast.LENGTH_SHORT).show();
        double result = Double.parseDouble(operand1EditText.getText().toString()) * Double.parseDouble(operand2EditText.getText().toString());
        resultTextView.setText(Double.toString(result));
    }

    public void subtractClick(View view) {
        Toast.makeText(this, "Click to subtract", Toast.LENGTH_SHORT).show();
        double result = Double.parseDouble(operand1EditText.getText().toString()) - Double.parseDouble(operand2EditText.getText().toString());
        resultTextView.setText(Double.toString(result));
    }


}
*/
