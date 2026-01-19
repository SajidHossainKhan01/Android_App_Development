 package com.mastercoding.dependencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Dependency Injection without Dagger

//        Battery battery = new Battery(100);
//        MemoryCard memoryCard = new MemoryCard(1024);
//        Processor processor = new Processor("Intel");
//        CPU cpu = new CPU(processor);
//
//        Mobile mobile = new Mobile(battery,memoryCard,cpu);


        // Dependency Injection With Dagger
        // We Need to annotate with @Inject all the constructors of these classes:
        // Mobile, Battery, CPU, Processor, MemoryCard

        // Use @Inject to annotate the constructor that Dagger should use
        // to create instances of a class. When a new instance is requested,
        // Dagger will obtain the required parameters values and invoke this constructor.



        // Now Dagger generates the codes for DI,
        // To us Dagger generated codes for DI, we need to create an Interface annotated with
        // @Component

        Mobile mobile;
        MobileComponent mobileComponent = DaggerMobileComponent.create();



        mobile = mobileComponent.getMobile();

        mobile.ringNow();


        // Our App is working fine!!













    }
}