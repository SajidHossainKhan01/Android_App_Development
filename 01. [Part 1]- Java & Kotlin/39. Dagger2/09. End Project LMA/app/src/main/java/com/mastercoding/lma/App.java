package com.mastercoding.lma;

import android.app.Application;

import com.mastercoding.lma.di.AppModule;
import com.mastercoding.lma.di.CourseShopComponent;
import com.mastercoding.lma.di.DaggerCourseShopComponent;

public class App extends Application {
    private static App app;
    private CourseShopComponent courseShopComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        courseShopComponent = DaggerCourseShopComponent.
             builder().appModule(new AppModule(this)).build();
    }

    public static App getApp() {
        return app;
    }


}
