package com.example.demo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    EditText N1, N2;
    TextView Result;
    Button Btn;
    Spinner Spin;
    String Operators[] = {"+", "-", "*", "/"};
    int index;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        createSpinner();
        Btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Result.setText(calc() + "");
            }
        });
    }

    void init() {
        N1 = (EditText)findViewById(R.id.EdtN1);
        N2 = (EditText)findViewById(R.id.EdtN2);
        Result = (TextView)findViewById(R.id.txtView);
        Btn = (Button)findViewById(R.id.btnResult);
        Spin = (Spinner)findViewById(R.id.spnOp);
    }

    void createSpinner() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Operators);
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_single_choice);
        Spin.setAdapter(adapter);
        Spin.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                index = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                index = -1;
            }
        });
    }

    double calc() {
        double X1 = Double.parseDouble(N1.getText().toString());
        double X2 = Double.parseDouble(N2.getText().toString());
        double result = 0;
        switch (index) {
            case 0: result = X1 + X2; break;
            case 1: result = X1 - X2; break;
            case 2: result = X1 * X2; break;
            case 3: try {result = X1 / X2;} catch(Error e) {Result.setText(e.getMessage());}; break;
        }
        return result;
    }
}
