package com.example.lab4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.example.lab4.model.WorkoutPartBase;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    int ADD_NEW_PART_INTENT_ID = 100;
    int RUN_INTENT_ID = 200;

    private ArrayList<WorkoutPartBase> fullWorkout = new ArrayList<>();
    private ArrayList<String> fullWorkoutList = new ArrayList<>();
    private MyAdapter testAdapter;
    private ListView testListView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.btnAddNew).setOnClickListener(this);
        findViewById(R.id.btnStartWorkout).setOnClickListener(this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);


        if (requestCode == ADD_NEW_PART_INTENT_ID && resultCode == Activity.RESULT_OK)
        {
            WorkoutPartBase newPart = (WorkoutPartBase) data.getSerializableExtra("NEW_PART");
            fullWorkout.add(newPart);
            fullWorkoutList.add(newPart.getWorkoutName() + " " + newPart.getSeconds());

            testListView = (ListView) findViewById(R.id.myListView);
            final ArrayAdapter<String> aa;
            aa = new ArrayAdapter<String>( this,android.R.layout.simple_list_item_1,
                    fullWorkoutList);
            testListView.setAdapter(aa);

            /*for(int i = 0; i < fullWorkout.size(); i++)
            {
                Log.d("Testaus", fullWorkout.get(i).getWorkoutName());
            }*/



        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnStartWorkout)
        {
            Intent intentStart = new Intent(this, RunProgramTimerActivity.class);
            intentStart.putExtra("WORKOUT_LIST", fullWorkout);
            startActivityForResult(intentStart, RUN_INTENT_ID);

        }
        else if (v.getId() == R.id.btnAddNew)
        {
            Intent intentAdd = new Intent(this, AddNewPartActivity.class);
            startActivityForResult(intentAdd, ADD_NEW_PART_INTENT_ID );
        }
    }
}
