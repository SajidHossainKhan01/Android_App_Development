package com.mastercoding.dependencyapp;

import javax.inject.Singleton;

import dagger.Component;


// We need to link the module with component
@Singleton
@Component(modules = BatteryModule.class)
public interface MobileComponent {
    Mobile getMobile();
}
