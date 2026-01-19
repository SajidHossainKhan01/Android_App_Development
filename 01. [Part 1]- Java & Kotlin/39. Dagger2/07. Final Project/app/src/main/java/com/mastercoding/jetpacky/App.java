package com.mastercoding.jetpacky;

import android.app.Application;

import com.mastercoding.jetpacky.DependencyInjection.ApplicationModule;
import com.mastercoding.jetpacky.DependencyInjection.ContactAppComponent;
import com.mastercoding.jetpacky.DependencyInjection.DaggerContactAppComponent;

public class App extends Application {

    private static App app;
    private ContactAppComponent contactAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        contactAppComponent = DaggerContactAppComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();

        // Dagger build the components when you rebuild the project
    }
    public static App getApp(){
        return app;
    }
    
    public ContactAppComponent getContactAppComponent(){
        return contactAppComponent;
    }

}
