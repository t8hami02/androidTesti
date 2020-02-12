package com.example.lab2_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnEnglish).setOnClickListener(this);
        findViewById(R.id.btnSuomi).setOnClickListener(this);
        findViewById(R.id.btnSuprise).setOnClickListener(this);
        findViewById(R.id.btnSverige).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        TextView myTextView = findViewById(R.id.myTextView);
        EditText myEditText = findViewById(R.id.myEditText);
        if (v.getId() == R.id.btnEnglish )
        {
            myTextView.setText("Hi "+ myEditText.getText());
        }
        else if (v.getId() == R.id.btnSuomi )
        {
            myTextView.setText("Terve "+ myEditText.getText());
        }
        else if (v.getId() == R.id.btnSuprise )
        {
            myTextView.setText("Hola "+ myEditText.getText());
        }
        else if (v.getId() == R.id.btnSverige )
        {
            myTextView.setText("Hejjsan "+ myEditText.getText());
        }
    }
}
