package com.mastercoding.jetpacky.DependencyInjection;
import com.mastercoding.jetpacky.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ContactAppComponent {

    // Let's link the modules here
    void inject(MainActivity mainActivity);
}
