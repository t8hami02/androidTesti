package com.example.lab4;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab4.model.WorkoutPartBase;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends ArrayAdapter<WorkoutPartBase> {

    private Context mContext;
    private ArrayList<WorkoutPartBase> workoutList = new ArrayList<>();

    public MyAdapter(@NonNull Context context,  @LayoutRes ArrayList<WorkoutPartBase> Arraylist) {
        super(context, 0, Arraylist);
        this.mContext = mContext;
        this.workoutList = workoutList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItem = convertView;
        WorkoutPartBase currentWorkout = workoutList.get(position);

        TextView workoutName = (TextView)listItem.findViewById(R.id.txtViewName);
        workoutName.setText("Workout");

        TextView workoutTime = (TextView)listItem.findViewById(R.id.txtViewName);
        workoutTime.setText(currentWorkout.getSeconds());


        return listItem;
    }
}
