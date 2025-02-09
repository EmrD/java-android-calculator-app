package com.emr.javacalculator;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner islemSpinner = findViewById(R.id.islem);
        Button submitBtn = findViewById(R.id.submitButton);
        EditText firstNumText = findViewById(R.id.firstNumEntry);
        EditText secondNumText = findViewById(R.id.secondNumEntry);
        String[] islemler = {"Select" , "Add" , "Subtract" , "Multiply" , "Divide"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, islemler);

        islemSpinner.setAdapter(adapter);

        submitBtn.setOnClickListener(new View.OnClickListener(){
            @SuppressLint("ShowToast")
            @Override
            public void onClick(View view){
                int firstNum = Integer.parseInt(firstNumText.getText().toString());
                int secondNum = Integer.parseInt(secondNumText.getText().toString());

                if (firstNumText.getText().toString().isEmpty() || secondNumText.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter valid numbers.", Toast.LENGTH_SHORT).show();
                    return;
                }

                int islemId = islemSpinner.getSelectedItemPosition();
                String islem = islemler[islemId];

                if (secondNum == 0 && islem.equals("Divide")){
                    Toast.makeText(MainActivity.this, "Cannot divide by 0!", Toast.LENGTH_SHORT).show();
                    return;
                }

                switch (islem){

                    case "Add":
                        Toast.makeText(MainActivity.this, "Result: " + (firstNum + secondNum), Toast.LENGTH_SHORT).show();
                        break;

                    case "Subtract":
                        Toast.makeText(MainActivity.this, "Result: " + (firstNum - secondNum), Toast.LENGTH_SHORT).show();
                        break;

                    case "Multiply":
                        Toast.makeText(MainActivity.this, "Result: " + (firstNum * secondNum), Toast.LENGTH_SHORT).show();
                        break;

                    case "Divide":
                        Toast.makeText(MainActivity.this, "Result: " + (firstNum / secondNum), Toast.LENGTH_SHORT).show();
                        break;
                    case "Select":

                    default:
                        Toast.makeText(MainActivity.this, "Please select an operation!", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }
}