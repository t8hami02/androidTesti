package com.example.lab4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.TextView;

import com.example.lab4.model.WorkoutPartBase;

import java.util.ArrayList;
import java.util.Timer;

public class RunProgramTimerActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {

    //Timer timer = new Timer();
    TextView myTxtView1;
    TextView myTxtView2;
    int parts = 0;
    TextToSpeech tts = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_run_program_timer);


        /*for(int i = 0; i < fullWorkout.size(); i++) {
            Log.d("Testaus", fullWorkout.get(i).getWorkoutName() + fullWorkout.get(i).getSeconds());
        }*/

        myTxtView1 =  findViewById(R.id.txtV3);
        myTxtView2 =  findViewById(R.id.txtVTime);
        ArrayList<WorkoutPartBase> fullWorkout = (ArrayList<WorkoutPartBase>) getIntent().getSerializableExtra("WORKOUT_LIST");


        myTxtView1.setText(fullWorkout.get(0).getWorkoutName());
        myTxtView2.setText(Integer.toString(fullWorkout.get(0).getSeconds()));

        tts = new TextToSpeech(this, this);
        tts.speak(fullWorkout.get(parts).getWorkoutName(),TextToSpeech.QUEUE_FLUSH, null);


        setTimer(fullWorkout.get(0).getSeconds());




    }

    public void setTimer(final int seconds)
    {
        myTxtView1 =  findViewById(R.id.txtV3);
        myTxtView2 =  findViewById(R.id.txtVTime);
        final ArrayList<WorkoutPartBase> fullWorkout = (ArrayList<WorkoutPartBase>) getIntent().getSerializableExtra("WORKOUT_LIST");


        CountDownTimer timer = new CountDownTimer((seconds+1) * 1000, 1000) {
            int x = seconds;
            @Override
            public void onTick(long millisUntilFinished) {
                myTxtView2.setText(Integer.toString(x));
                x--;

            }

            @Override
            public void onFinish() {
                parts++;
                if (parts < fullWorkout.size())
                {
                    myTxtView1.setText(fullWorkout.get(parts).getWorkoutName());
                    myTxtView2.setText(Integer.toString(fullWorkout.get(parts).getSeconds()));
                    setTimer(fullWorkout.get(parts).getSeconds());
                    tts.speak(fullWorkout.get(parts).getWorkoutName(),TextToSpeech.QUEUE_FLUSH, null);
                }
                else
                {
                    Intent resultIntent = new Intent();
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                }
            }
        }.start();


    }

    @Override
    public void onInit(int status) {

    }
}
