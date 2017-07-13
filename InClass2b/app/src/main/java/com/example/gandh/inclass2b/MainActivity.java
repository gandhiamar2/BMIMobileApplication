package com.example.gandh.inclass2b;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    Double weight;
    Double weight_up ;
    Double weight_low;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText et1 =  (EditText) findViewById(R.id.editText1);
        final EditText et2 = (EditText) findViewById(R.id.editText2);
        final TextView tv = (TextView) findViewById(R.id.textView6);
        Button button = (Button) findViewById(R.id.button);
        final RadioGroup rg = (RadioGroup) findViewById(R.id.rg);
          final String TAG = "demo";
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int id =   rg.getCheckedRadioButtonId();
                int b1 = R.id.radioButton1;
                int b2 = R.id.radioButton2;
                int b3 = R.id.radioButton3;
                int b4 = R.id.radioButton4;
                String weight_final;


                Toast toast = Toast.makeText(getApplicationContext(),"Weight calculated",Toast.LENGTH_SHORT);
                Toast toast1 = Toast.makeText(getApplicationContext(),"select any BMI",Toast.LENGTH_SHORT);
                Toast toast2 = Toast.makeText(getApplicationContext(),"enter proper height values for feet/inches",Toast.LENGTH_SHORT);
                if(et1.getText().toString().equals("") || et2.getText().toString().equals("")  ){
                    toast2.show();
                    Log.d(TAG,"IN");
                                    }
                else {

                    int height = Integer.parseInt(et1.getText().toString()) * 12 + Integer.parseInt(et2.getText().toString());
                    Log.d(TAG,height+"");
                    if (height == 0) {
                        toast2.show();
                    } else {
                        if (id == b1) {
                            weight = (18.5 * height * height) / 703;
                            tv.setText("Your weight should be less than " + weight.floatValue() + "lb");

                            toast.show();
                        } else if (id == b2) {
                            weight_low = (18.5 * height * height) / 703;
                            weight_up = (24.9 * height * height) / 703;
                            tv.setText("Your weight should be in between " + weight_low.floatValue() + " to " + weight_up.floatValue() + "lb");

                            toast.show();
                        } else if (id == b3) {
                            weight_low = (25.0 * height * height) / 703;
                            weight_up = (29.9 * height * height) / 703;
                            tv.setText("Your weight should be in between " + weight_low.floatValue() + " to " + weight_up.floatValue() + "lb");

                            toast.show();
                        } else if (id == b4) {
                            weight = (29.9 * height * height) / 703;
                            tv.setText("Your weight should be greater than " + weight + "lb");

                            toast.show();
                        } else if (id == -1) {
                            toast1.show();
                        }
                    }
                }

            }
        });

        }
    }

