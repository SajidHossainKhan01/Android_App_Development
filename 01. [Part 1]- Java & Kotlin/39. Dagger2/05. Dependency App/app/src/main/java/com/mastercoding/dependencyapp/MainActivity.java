 package com.mastercoding.dependencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import javax.inject.Inject;

 public class MainActivity extends AppCompatActivity {


    /**
     *  Custom Application Class:
     *
     *  1- If there are tasks that need to run before the creation of the first activity
     *  2- If there are static immutable data such as shared network client object
     *  3- If there are global objects such as data persistence and crash reporting
     *
     *
     * */




    @Inject
    Mobile mobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getApp().getMobileComponent().getMobile();



        // Congratz!! Your code is now clean and according to code architecture
    }
}