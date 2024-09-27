package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setTitle("Adding Numbers");
        EditText txt1 = findViewById(R.id.editTextText);
        EditText txt2 = findViewById(R.id.editTextText2);
        Button btn = findViewById(R.id.button);
        Button btn2 = findViewById(R.id.button2);
        Button btn3 = findViewById(R.id.button3);
        Button btn4 = findViewById(R.id.button4);

        TextView res = findViewById(R.id.textView2);

        btn.setOnClickListener(view -> {
            double[] numbers = getNumbers(txt1, txt2);
            if (numbers != null) {
                double eredmeny = numbers[0] + numbers[1];
                res.setText(String.valueOf(eredmeny));
            }
        });

        btn2.setOnClickListener(view -> {
            double[] numbers = getNumbers(txt1, txt2);
            if (numbers != null) {
                double eredmeny = numbers[0] - numbers[1];
                res.setText(String.valueOf(eredmeny));
            }
        });

        btn3.setOnClickListener(view -> {
            double[] numbers = getNumbers(txt1, txt2);
            if (numbers != null) {
                double eredmeny = numbers[0] * numbers[1];
                res.setText(String.valueOf(eredmeny));
            }
        });

        btn4.setOnClickListener(view -> {
            double[] numbers = getNumbers(txt1, txt2);
            if (numbers[1] != 0) {
                double eredmeny = numbers[0] / numbers[1];
                res.setText(String.valueOf(eredmeny));
            } else {
                Toast.makeText(SecondActivity.this, "Nem lehet nullával osztani!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private double[] getNumbers(EditText txt1, EditText txt2) {
        String input1 = txt1.getText().toString();
        String input2 = txt2.getText().toString();

        if (input1.isEmpty() || input2.isEmpty()) {
            Toast.makeText(SecondActivity.this, "Kérlek, add meg mindkét számot!", Toast.LENGTH_SHORT).show();
            return null;
        }

        try {
            double num1 = Double.parseDouble(input1);
            double num2 = Double.parseDouble(input2);
            return new double[]{num1, num2};
        } catch (NumberFormatException e) {
            Toast.makeText(SecondActivity.this, "Kérlek, érvényes számokat adj meg!", Toast.LENGTH_SHORT).show();
            return null;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("SecondActivity", "SecondActiviy: onResume()");
    }
}