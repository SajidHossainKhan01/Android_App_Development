package com.mastercoding.dependencyapp;

import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class Mobile {
    Battery battery;
    MemoryCard memoryCard;
    CPU cpu;

    // Now battery is an interface !!

    // We can't pass battery interface, we need to pass a child
    @Inject
    public Mobile(Battery battery, MemoryCard memoryCard, CPU cpu) {
        this.battery = battery;
        this.memoryCard = memoryCard;
        this.cpu = cpu;

        // Displaying the creation time of the instance
        SimpleDateFormat df = new SimpleDateFormat("EEE, d MMM yyyy, HH:mm:ss");
        String time = df.format(Calendar.getInstance().getTime());
        DisplayTime(time);
    }

    private void DisplayTime(String time) {
        Log.v("TAGY", "Instance Created At: "+time);
    }


    public void ringNow(){
        System.out.println("Ringing");
    }



    // We learned how to make Dependency Injection with Empty Constructors

    /***
     * IN This lesson, we are going to learn how to make DI with states in constructors
     *  (Parameters in Constructor)
    **/


}
