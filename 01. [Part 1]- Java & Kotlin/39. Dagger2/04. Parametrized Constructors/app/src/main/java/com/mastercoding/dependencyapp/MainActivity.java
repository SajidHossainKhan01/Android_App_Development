 package com.mastercoding.dependencyapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {


    /**
     * In some cases, you need to pass an interface as constructor parameter (Dependency),
     * So you need to configure the interface to allow the injection
     *
     *
     * */






    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Dependency Injection without Dagger
        // Battery battery = new Battery(100);
        // MemoryCard memoryCard = new MemoryCard(1024);
        // Processor processor = new Processor("Intel");
        // CPU cpu = new CPU(processor);

        // Mobile mobile = new Mobile(battery,memoryCard,cpu);


        // Dependency Injection With Dagger
        // Now Dagger generates the codes for DI,
        // To us Dagger generated codes for DI, we need to create an Interface annotated with
        // @Component

        Mobile mobile;

        // create(): for empty constructors
        // Builder(): for parametrized constructors

        MobileComponent mobileComponent = DaggerMobileComponent.builder()
                .batteryModule(new BatteryModule(100))
                .build();




        mobile = mobileComponent.getMobile();

        mobile.ringNow();











    }
}