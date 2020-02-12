package com.example.lab3_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {



    EditText myEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myEditText = (EditText) findViewById(R.id.myEditText);

        loadData();

    }

    @Override
    protected void onPause() {
        super.onPause();
        saveData();

    }

    @Override
    protected void onResume() {
        super.onResume();
        loadData();
    }

    private void saveData() {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("EditText", myEditText.getText().toString());

        editor.commit();
    }

    private void loadData() {
        SharedPreferences sp = getPreferences(MODE_PRIVATE);
        myEditText.setText(sp.getString("EditText", myEditText.toString()));
    }
}
