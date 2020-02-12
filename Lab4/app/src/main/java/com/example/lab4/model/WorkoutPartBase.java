package com.example.lab4.model;

import androidx.lifecycle.ViewModel;

import java.io.Serializable;

public class WorkoutPartBase extends ViewModel implements Serializable {

    private String workoutName;
    private int seconds;

    public WorkoutPartBase(int seconds, String workoutName) {
        this.seconds = seconds;
        this.workoutName = workoutName;
    }


    public String getWorkoutName() {
        return workoutName;
    }

    public void setWorkoutName(String workoutName) {
        this.workoutName = workoutName;
    }


    public int getSeconds() {
        return seconds;
    }

    public void setSeconds(int seconds) {
        this.seconds = seconds;
    }

}
