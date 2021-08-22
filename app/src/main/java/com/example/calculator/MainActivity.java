package com.example.calculator;


import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    EditText etext;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selectedOption(View v)
    {
        Button btn=(Button) v;
        String expression;
        etext = findViewById(R.id.editTextNumber3);
        if(v.getTag().toString().equals("=")) {
            expression = etext.getText().toString();
            if (expression.isEmpty()) {
                Toast.makeText(this, "Enter Some Value", Toast.LENGTH_SHORT).show();
            } else {
                double result = Eval.eval(expression);
                etext.setText(result + "");
            }
        }

        else if(v.getTag().toString().equals("del")) {
            expression = etext.getText().toString();
            if (expression.isEmpty()) {
                Toast.makeText(this, "Nothing to Delete", Toast.LENGTH_SHORT).show();
            } else {
                etext.setText(expression.substring(0, expression.length() - 1));
            }
        }


        else if(v.getTag().toString().equals("clr")) {
            expression = "";
            etext.setText(expression);
            }

        else {
            String id = v.getTag().toString();
            expression = etext.getText().toString() + id;
            etext.setText(expression);
        }
    }
    }
