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
            public void onClick(View v) {
                double BulbTConsumption = 0;
                double OvenTConsumption = 0;
                double BoilerTConsumption = 0;
                double MitadTConsumption = 0;

                double power = 0.0;
                double quantity = 0.0;
                double usage = 0.0;

                double power1 = 0.0;
                double quantity1 = 0.0;
                double usage1 = 0.0;

                double power2 = 0.0;
                double quantity2 = 0.0;
                double usage2 = 0.0;

                double power3 = 0.0;
                double quantity3 = 0.0;
                double usage3 = 0.0;
                boolean error = false;

                if (bulb1.isChecked() && !error) {
                    pwr1.setFocusable(true);
                    EditText editText = findViewById(R.id.pwr1);
                    EditText editText1 = findViewById(R.id.qty1);
                    EditText editText2 = findViewById(R.id.usg1);

                    if (editText.getText().toString().isEmpty()) {
                        editText.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        power = Double.parseDouble(pwr1.getText().toString());
                    }
                    if (editText1.getText().toString().isEmpty()) {
                        editText1.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        quantity = Double.parseDouble(qty1.getText().toString());
                    }
                    if (editText2.getText().toString().isEmpty()) {
                        editText2.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        usage = Double.parseDouble(usg1.getText().toString());
                    }
                    if(!error) {
                        BulbTConsumption = power * quantity * usage;
                        BulbTConsumption = BulbTConsumption * 30;
                        Double Usg1 = Double.parseDouble(usg1.getText().toString());
                        int l = Integer.parseInt(usg1.getText().toString());
                        if (l > 24) {
                            error = true;
                            usg1.setError("Usage must be below 24");
                        }
                    }
                }
                if (elic1.isChecked()) {
                    EditText editText3 = findViewById(R.id.pwr2);
                    EditText editText4 = findViewById(R.id.qty2);
                    EditText editText5 = findViewById(R.id.usg2);

                    if (editText3.getText().toString().isEmpty()) {
                        editText3.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        power1 = Double.parseDouble(pwr2.getText().toString());
                    }
                    if (editText4.getText().toString().isEmpty()) {
                        editText4.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        quantity1 = Double.parseDouble(qty2.getText().toString());
                    }
                    if (editText4.getText().toString().isEmpty()) {
                        editText5.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        usage1 = Double.parseDouble(usg2.getText().toString());
                    }
                    if(!error) {
                        OvenTConsumption = power1 * quantity1 * usage1;
                        OvenTConsumption = OvenTConsumption * 30;
                        Double Usg1 = Double.parseDouble(usg1.getText().toString());
                        int l = Integer.parseInt(usg1.getText().toString());
                        if (l > 24) {
                            error = true;
                            usg1.setError("Usage must be below 24");
                        }
                    }
                }
                if (elic2.isChecked()) {
                    EditText editText6 = findViewById(R.id.pwr3);
                    EditText editText7 = findViewById(R.id.qty3);
                    EditText editText8 = findViewById(R.id.usg3);

                    if (editText6.getText().toString().isEmpty()) {
                        editText6.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        power2 = Double.parseDouble(pwr3.getText().toString());
                    }
                    if (editText7.getText().toString().isEmpty()) {
                        editText7.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        quantity2 = Double.parseDouble(qty3.getText().toString());
                    }
                    if (editText8.getText().toString().isEmpty()) {
                        editText8.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        usage2 = Double.parseDouble(usg3.getText().toString());
                    }
                    if(!error) {
                        BoilerTConsumption = power2 * quantity2 * usage2;
                        BoilerTConsumption = BoilerTConsumption * 30;
                        Double Usg1 = Double.parseDouble(usg1.getText().toString());
                        int l = Integer.parseInt(usg1.getText().toString());
                        if (l > 24) {
                            error = true;
                            usg1.setError("Usage must be below 24");
                        }
                    }
                }
                if (elic3.isChecked()) {
                    EditText editText10 = findViewById(R.id.pwr4);
                    EditText editText11 = findViewById(R.id.qty4);
                    EditText editText12 = findViewById(R.id.usg4);

                    if (editText10.getText().toString().isEmpty()) {
                        editText10.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        power3 = Double.parseDouble(pwr4.getText().toString());
                    }
                    if (editText11.getText().toString().isEmpty()) {
                        editText11.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        quantity3 = Double.parseDouble(qty4.getText().toString());
                    }
                    if (editText12.getText().toString().isEmpty()) {
                        editText12.setError("Please enter a value");
                        error=true;
                    } else if(!error){

                        usage3 = Double.parseDouble(usg4.getText().toString());
                    }
                    if(!error) {
                        MitadTConsumption = power3 * quantity3 * usage3 * 30;
                        Double Usg1 = Double.parseDouble(usg1.getText().toString());
                        int l = Integer.parseInt(usg1.getText().toString());
                        if (l > 24) {
                            error = true;
                            usg1.setError("Usage must be below 24");
                        }
                    }
                }
                if (!error) {
                    if (!bulb1.isChecked() && !elic1.isChecked() && !elic2.isChecked() && !elic3.isChecked()) {
                        Toast.makeText(MainActivity.this, "please fill the above value! ", Toast.LENGTH_SHORT).show();
                    }
                    double total_Consumption;
                    total_Consumption = MitadTConsumption + BoilerTConsumption
                            + BulbTConsumption + OvenTConsumption;
                    total_Consumption = total_Consumption / 1000;
                    if (total_Consumption == 0.0) {
                        consumption.setText("0.0");
                    } else {
                        consumption.setText(Double.toString(total_Consumption) + "Kwh");
                    }


                    double payable = 0.0;
//               Consumption Calculation
                    if (total_Consumption <= 50) {
                        payable = total_Consumption * 0.2730 + 10;

                    } else if (total_Consumption > 50 && total_Consumption <= 100) {
                        payable = total_Consumption * 0.7670 + 42;
                    } else if (total_Consumption > 100 && total_Consumption <= 200) {
                        payable = total_Consumption * 1.6250 + 42;
                    } else if (total_Consumption > 200 && total_Consumption <= 300) {
                        payable = total_Consumption * 2.0000 + 42;
                    } else if (total_Consumption > 300 && total_Consumption <= 400) {
                        payable = total_Consumption * 2.2000 + 42;
                    } else if (total_Consumption > 400 && total_Consumption <= 500) {
                        payable = total_Consumption * 2.4050 + 42;
                    } else if (total_Consumption > 500) {
                        payable = total_Consumption * 2.4810 + 42;
                    }
                    if (total_Consumption == 0.0) {
                        bill.setText("0.0");
                    } else {
                        bill.setText(Double.toString(payable) + "Birr");
                    }
                }
            }

        });


        EditText p1 = findViewById(R.id.pwr1);
        EditText p2 = findViewById(R.id.pwr2);
        EditText p3 = findViewById(R.id.pwr3);
        EditText p4 = findViewById(R.id.pwr4);
        EditText u1 = findViewById(R.id.usg1);
        EditText u2 = findViewById(R.id.usg2);
        EditText u3 = findViewById(R.id.usg3);
        EditText u4 = findViewById(R.id.usg4);
        EditText q1 = findViewById(R.id.qty1);
        EditText q2 = findViewById(R.id.qty2);
        EditText q3 = findViewById(R.id.qty3);
        EditText q4 = findViewById(R.id.qty4);



        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                p1.setText("");
                p2.setText("");
                p3.setText("");
                p4.setText("");
                u1.setText("");
                u2.setText("");
                u3.setText("");
                u4.setText("");
                q1.setText("");
                q2.setText("");
                q3.setText("");
                q4.setText("");
                consumption.setText("0.0");
                bill.setText("0.0");

                bulb1.setChecked(false);
                elic1.setChecked(false);
                elic2.setChecked(false);
                elic3.setChecked(false);
                p1.setError(null);
                q1.setError(null);
                u1.setError(null);
                p2.setError(null);
                q2.setError(null);
                u2.setError(null);
                p3.setError(null);
                q3.setError(null);
                u3.setError(null);
                p4.setError(null);
                q4.setError(null);
                u4.setError(null);



            }
        });




    }






}
