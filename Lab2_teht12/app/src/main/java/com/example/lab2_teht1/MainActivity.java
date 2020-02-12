package com.example.lab2_teht1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> CountriesList = new ArrayList<String>();
    EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.add_button).setOnClickListener(this);
        findViewById(R.id.remove_button).setOnClickListener(this);

        final String[] COUNTRIES = new String[]{
                "Afganistan", "Albania", "Algeria", "American samoa", "Andorra",
                "Angola", "Anguilla", "Antarctica", "Antigua and Barbuda", "Argentina",
                "Armeania", "Aruba", "Australia", "Austria", "Azerbaijan"
        };



        for (int i = 0; i< COUNTRIES.length; i++)
        {
            CountriesList.add(COUNTRIES[i]);
        }

        updateListView();
    }

    @Override
    public void onClick(View v) {
        editText = (EditText) findViewById(R.id.text_editor);

        if (v.getId() == R.id.add_button)
        {
            CountriesList.add(editText.getText().toString());
        }
        else if (v.getId() == R.id.remove_button)
        {
            for (int i = CountriesList.size()-1; i >= 0; i--){
                Log.d("TESTIA" , "onClick: "+ CountriesList.get(i) + " " + editText.getText().toString());
                if (editText.getText().toString().equals(CountriesList.get(i)) )
                {

                    CountriesList.remove(i);

                }

            }

        }

        updateListView();

    }

    public void updateListView()
    {
        ListView myListView = (ListView) findViewById(R.id.country_list_view);
        final ArrayAdapter<String> aa;
        aa = new ArrayAdapter<String>( this,android.R.layout.simple_list_item_1,
                CountriesList);
        myListView.setAdapter(aa);
    }
}
