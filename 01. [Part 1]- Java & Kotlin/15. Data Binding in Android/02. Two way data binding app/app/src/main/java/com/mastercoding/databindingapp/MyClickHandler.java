package com.mastercoding.databindingapp;

import android.content.Context;
import android.view.View;
import android.widget.Toast;

import com.mastercoding.databindingapp.databinding.ActivityMainBinding;

public class MyClickHandler {

    Context context;
    ActivityMainBinding activityMainBinding;
    public MyClickHandler(Context context, ActivityMainBinding activityMainBinding) {
        this.context = context;
        this.activityMainBinding = activityMainBinding;
    }

    public void onButton1Clicked(View view){
        Toast.makeText(
                context,
                "You Clicked the button",
                Toast.LENGTH_SHORT).show();



    }

}
