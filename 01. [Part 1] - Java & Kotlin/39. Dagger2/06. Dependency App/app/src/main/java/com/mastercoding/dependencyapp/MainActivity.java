 package com.mastercoding.dependencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import javax.inject.Inject;

 public class MainActivity extends AppCompatActivity {


    /**
     *  Dagger Singleton
     *
     *
     *
     * */




    @Inject
    Mobile mobile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        App.getApp().getMobileComponent().getMobile().ringNow();



        // Let's make the singleton instances from the Mobile
        // to make sure that we have always one single instance of mobile during runtime


        Button btn = findViewById(R.id.button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(i);
            }
        });

    }


}