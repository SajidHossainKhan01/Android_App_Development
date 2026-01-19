package com.mastercoding.dependencyapp;

import android.app.Application;

public class App extends Application {

    private static App app;
    private MobileComponent mobileComponent;

    public static App getApp(){

        return app;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        mobileComponent = DaggerMobileComponent.builder()
                .batteryModule(new BatteryModule(99))
                .build();
    }

    public MobileComponent getMobileComponent(){
        return mobileComponent;
    }
}
