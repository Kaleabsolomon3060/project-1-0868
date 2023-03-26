package com.example.electricbillcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //    CHECKBOX
    private CheckBox bulb1;
    private CheckBox elic1;
    private CheckBox elic2;
    private CheckBox elic3;
    //    LIGHT BULB
    private TextInputEditText pwr1;
    private TextInputEditText qty1;
    private TextInputEditText usg1;

    //    OVEN
    private TextInputEditText pwr2;
    private TextInputEditText qty2;
    private TextInputEditText usg2;

    //    BOILER
    private TextInputEditText pwr3;
    private TextInputEditText qty3;
    private TextInputEditText usg3;

    //    MITAD
    private TextInputEditText pwr4;
    private TextInputEditText qty4;
    private TextInputEditText usg4;

    //    CALCULATE BUTTON
    private Button calbtn;

    private Button reset;

    //    CONSUMPTION
    private TextView consumption;

    //    PAYABLE
    private TextView bill;
    //    LAYOUT

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox bulb1 = findViewById(R.id.bulb1);
        CheckBox elic1 = findViewById(R.id.elic1);
        CheckBox elic2 = findViewById(R.id.elic2);
        CheckBox elic3 = findViewById(R.id.elic3);

        pwr1 = findViewById(R.id.pwr1);
        qty1 = findViewById(R.id.qty1);
        usg1 = findViewById(R.id.usg1);

        pwr2 = findViewById(R.id.pwr2);
        qty2 = findViewById(R.id.qty2);
        usg2 = findViewById(R.id.usg2);

        pwr3 = findViewById(R.id.pwr3);
        qty3 = findViewById(R.id.qty3);
        usg3 = findViewById(R.id.usg3);

        pwr4 = findViewById(R.id.pwr4);
        qty4 = findViewById(R.id.qty4);
        usg4 = findViewById(R.id.usg4);

        consumption = findViewById(R.id.viewconsumption);
        bill = findViewById(R.id.viewPayable);

        calbtn = findViewById(R.id.calbtn);
        reset = findViewById(R.id.reset_btn);

        bulb1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                pwr1.setEnabled(isChecked);
                qty1.setEnabled(isChecked);
                usg1.setEnabled(isChecked);
                if(!isChecked){
                    pwr1.setText("");
                    qty1.setText("");
                    usg1.setText("");
                }

            }
        });
        elic1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                pwr2.setEnabled(isChecked);
                qty2.setEnabled(isChecked);
                usg2.setEnabled(isChecked);
                if(!isChecked){
                    pwr2.setText("");
                    qty2.setText("");
                    usg2.setText("");
                }
            }
        });
        elic2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                pwr3.setEnabled(isChecked);
                qty3.setEnabled(isChecked);
                usg3.setEnabled(isChecked);
                if(!isChecked){
                    pwr3.setText("");
                    qty3.setText("");
                    usg3.setText("");
                }

            }
        });
        elic3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                pwr4.setEnabled(isChecked);
                qty4.setEnabled(isChecked);
                usg4.setEnabled(isChecked);
                if(!isChecked){
                    pwr4.setText("");
                    qty4.setText("");
                    usg4.setText("");
                }


            }
        });


        calbtn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                double BulbTConsumption = 0;
                double OvenTConsumption = 0;
                double BoilerTConsumption = 0;
                double MitadTConsumption = 0;

                double power=0.0;
                double quantity=0.0;
                double usage=0.0;

                double power1=0.0;
                double quantity1=0.0;
                double usage1=0.0;

                double power2=0.0;
                double quantity2=0.0;
                double usage2=0.0;

                double power3=0.0;
                double quantity3=0.0;
                double usage3=0.0;

                if(bulb1.isChecked()){
                    pwr1.setFocusable(true);
                    EditText editText = findViewById(R.id.pwr1);
                    EditText editText1 = findViewById(R.id.qty1);
                    EditText editText2 = findViewById(R.id.usg1);

                    if (editText.getText().toString().isEmpty()) {
                        editText.setError("Please enter a value");
                    }else{

                        power = Double.parseDouble(pwr1.getText().toString());
                    }
                    if (editText1.getText().toString().isEmpty()) {
                        editText1.setError("Please enter a value");
                    } else{

                        quantity = Double.parseDouble(qty1.getText().toString());
                    }
                    if (editText2.getText().toString().isEmpty()) {
                        editText2.setError("Please enter a value");
                    }
                    else {

                        usage = Double.parseDouble(usg1.getText().toString());
                    }



                    BulbTConsumption = power*quantity*usage;
                    BulbTConsumption=BulbTConsumption*30;
                }
                if(elic1.isChecked()){
                    EditText editText3 = findViewById(R.id.pwr2);
                    EditText editText4 = findViewById(R.id.qty2);
                    EditText editText5 = findViewById(R.id.usg2);

                    if (editText3.getText().toString().isEmpty()) {
                        editText3.setError("Please enter a value");
                    }else{

                        power1 = Double.parseDouble(pwr2.getText().toString());
                    }
                    if (editText4.getText().toString().isEmpty()) {
                        editText4.setError("Please enter a value");
                    } else
                    {

                        quantity1 = Double.parseDouble(qty2.getText().toString());
                    }
                    if (editText4.getText().toString().isEmpty())
                    {
                        editText5.setError("Please enter a value");
                    }
                    else
                    {

                        usage1 = Double.parseDouble(usg2.getText().toString());
                    }


                    OvenTConsumption = power1*quantity1*usage1;
                    OvenTConsumption= OvenTConsumption*30;
                }
                if(elic2.isChecked()){
                    EditText editText6 = findViewById(R.id.pwr3);
                    EditText editText7 = findViewById(R.id.qty3);
                    EditText editText8 = findViewById(R.id.usg3);

                    if (editText6.getText().toString().isEmpty()) {
                        editText6.setError("Please enter a value");
                    }else{

                        power2 = Double.parseDouble(pwr3.getText().toString());
                    }
                    if (editText7.getText().toString().isEmpty()) {
                        editText7.setError("Please enter a value");
                    } else
                    {

                        quantity2 = Double.parseDouble(qty3.getText().toString());
                    }
                    if (editText8.getText().toString().isEmpty())
                    {
                        editText8.setError("Please enter a value");
                    }
                    else {

                        usage2 = Double.parseDouble(usg3.getText().toString());
                    }


                    BoilerTConsumption = power2*quantity2*usage2;
                    BoilerTConsumption= BoilerTConsumption*30;
                }
                if(elic3.isChecked()){
                    EditText editText10 = findViewById(R.id.pwr4);
                    EditText editText11 = findViewById(R.id.qty4);
                    EditText editText12 = findViewById(R.id.usg4);

                    if (editText10.getText().toString().isEmpty()) {
                        editText10.setError("Please enter a value");
                    }else{

                        power3 = Double.parseDouble(pwr4.getText().toString());
                    }
                    if (editText11.getText().toString().isEmpty()) {
                        editText11.setError("Please enter a value");
                    } else
                    {

                        quantity3 = Double.parseDouble(qty4.getText().toString());
                    }
                    if (editText12.getText().toString().isEmpty())
                    {
                        editText12.setError("Please enter a value");
                    }
                    else {

                        usage3 = Double.parseDouble(usg4.getText().toString());
                    }


                    MitadTConsumption = power3*quantity3*usage3;

                }
                if(!bulb1.isChecked()&&!elic1.isChecked() && !elic2.isChecked() && !elic3.isChecked()){
                    Toast.makeText(MainActivity.this, "please fill the above value! ", Toast.LENGTH_SHORT).show();
                