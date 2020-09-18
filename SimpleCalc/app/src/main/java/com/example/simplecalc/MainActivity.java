package com.example.simplecalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText Result;
    double A = 0, B = 0, result = 0;
    String operator="", operand="0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Result = (EditText)findViewById(R.id.edtResult);
        int[] Buttons = {
                R.id.btn0, R.id.btn1, R.id.btn2,
                R.id.btn3, R.id.btn4, R.id.btn5,
                R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9,
                R.id.btnDel, R.id.btnDiv, R.id.btnMult,
                R.id.btnMinus, R.id.btnPlus, R.id.btnEqual
        };

        for(int id:Buttons) {
            View v = (View)findViewById(id);
            v.setOnClickListener(this);
        }


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnPlus:
                operator="+";
                A = Double.parseDouble(operand);
                operand = "0";
                break;
            case R.id.btnMinus:
                operator="-";
                A = Double.parseDouble(operand);
                operand = "0";
                break;
            case R.id.btnMult:
                operator="*";
                A = Double.parseDouble(operand);
                operand = "0";
                break;
            case R.id.btnDiv:
                operator="/";
                A = Double.parseDouble(operand);
                operand = "0";
                break;
            case R.id.btnEqual:
                B = Double.parseDouble(operand);
                switch (operator) {
                    case "+": result = A + B; break;
                    case "-": result = A - B; break;
                    case "*": result = A * B; break;
                    case "/": result = B == 0 ? 0 : A + B; break;
                }
                operand = Double.toString(result);
                Result.setText(operand);
                break;
            case R.id.btnDel:
                Result.setText("");
                operand="0";
                A = B = result = 0;
                break;
            default:
                if (operand.equals("0"))
                    operand ="";
                operand += ((Button)v).getText().toString();
                Result.setText(operand);

        }
    }
}
