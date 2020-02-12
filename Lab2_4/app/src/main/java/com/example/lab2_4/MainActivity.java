package com.example.lab2_4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btnCall).setOnClickListener(this);
        findViewById(R.id.btnMap).setOnClickListener(this);
        findViewById(R.id.btnGo).setOnClickListener(this);



    }

    @Override
    public void onClick(View v) {

        EditText myEditText = findViewById(R.id.myEditText);

        Uri location = Uri.parse("geo:65.060833, 25.466677");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, location);

        Uri number = Uri.parse("tel:+358 20 6110200");
        Intent callIntent = new Intent(Intent.ACTION_DIAL, number);

        Uri myWebpage = Uri.parse(myEditText.getText().toString());
        Intent webIntent = new Intent(Intent.ACTION_VIEW, myWebpage);


        if (v.getId() == R.id.btnMap)
        {
            startActivity(mapIntent);
        }
        else if (v.getId() == R.id.btnCall)
        {
            startActivity(callIntent);
        }
        else if (v.getId() == R.id.btnGo)
        {
            startActivity(webIntent);
        }
    }
}
