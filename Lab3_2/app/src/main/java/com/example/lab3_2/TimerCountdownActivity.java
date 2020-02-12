package com.example.lab3_2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.TextView;

public class TimerCountdownActivity extends AppCompatActivity {

    private Ringtone r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer_countdown);


        final TextView txtSeconds = findViewById(R.id.txtSeconds);
        final String test = getIntent().getStringExtra("TEST");
        final int seconds = Integer.parseInt(test);

        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        r = RingtoneManager.getRingtone(getApplicationContext(), notification);

        CountDownTimer timer = new CountDownTimer(seconds*1000, 1000) {
             int x = seconds;

            public void onTick(long millisUntilFinished) {
                txtSeconds.setText(Integer.toString(x));
                x--;
            }

            public void onFinish() {
                txtSeconds.setText(Integer.toString(x));


                r.play();

            }
        }.start();



    }

    @Override
    protected void onStop() {
        super.onStop();
        countDownTimer.cancel();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        r.stop();
    }
}
