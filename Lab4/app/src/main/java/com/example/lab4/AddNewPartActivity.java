package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lab4.model.WorkoutPartBase;

public class AddNewPartActivity extends AppCompatActivity implements View.OnClickListener {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_part);

        findViewById(R.id.btnAdd).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnAdd)
        {
            final EditText myEditText = findViewById(R.id.editText1);
            String testEditText = myEditText.getText().toString();
            RadioGroup myRadioGrp = (RadioGroup) findViewById(R.id.myRadioGrp);


            int selectedId = myRadioGrp.getCheckedRadioButtonId();
            RadioButton myRadiobtn = (RadioButton) findViewById(selectedId);

            if(isNumeric(testEditText))
            {
                WorkoutPartBase part = new WorkoutPartBase(Integer.parseInt(myEditText.getText().toString()), myRadiobtn.getText().toString());

                Intent resultIntent = new Intent();
                resultIntent.putExtra("NEW_PART", part);
                setResult(Activity.RESULT_OK, resultIntent);
                finish();
            }
            else
            {
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
