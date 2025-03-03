package com.example.hesap_mac;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText display;
    private String input = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        display = findViewById(R.id.display);
        setButtonListeners();
    }

    private void setButtonListeners() {
        int[] buttonIds = { R.id.btn_0, R.id.btn_1, R.id.btn_2, R.id.btn_3, R.id.btn_4, R.id.btn_5,
                R.id.btn_6, R.id.btn_7, R.id.btn_8, R.id.btn_9, R.id.btn_add, R.id.btn_subtract,
                R.id.btn_multiply, R.id.btn_divide, R.id.btn_dot, R.id.btn_equal, R.id.btn_clear,
                R.id.btn_pow, R.id.btn_fact, R.id.btn_sqrt };

        for (int id : buttonIds) {
            Button button = findViewById(id);
            button.setOnClickListener(this::onButtonClick);
        }
    }

    public void onButtonClick(View view) {
        Button button = (Button) view;
        String buttonText = button.getText().toString();

        if (buttonText.equals("C")) {
            input = "";
        } else if (buttonText.equals("=")) {
            input = evaluateExpression(input);
        } else {
            input += buttonText;
        }
        display.setText(input);
    }

    private String evaluateExpression(String expression) {
        try {
            return String.valueOf(new Expression(expression).calculate());
        } catch (Exception e) {
            return "Error";
        }
    }
}