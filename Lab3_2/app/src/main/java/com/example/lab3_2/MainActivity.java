package com.example.lab3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnStart).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {

        final EditText myEditText = findViewById(R.id.myEditText);


        if (v.getId() == R.id.btnStart)
        {
            String testEditText = myEditText.getText().toString();


            if (isNumeric(testEditText))
            {
                Log.d("NumTest", "onClick: It is number ");

                Intent intentCountdown = new Intent(this, TimerCountdownActivity.class);
                intentCountdown.putExtra("TEST", testEditText);

                startActivity(intentCountdown);
            }
            else
            {
                Log.d("NumTest", "onClick: It is NOT number ");
                Toast.makeText(getBaseContext(), "Given input is NOT a number", Toast.LENGTH_SHORT).show();

            }



        }
    }
    public static boolean isNumeric(String str) {
        try {
            Double.parseDouble(str);
            return true;
        } catch(NumberFormatException e){
            return false;
        }
    }

}
