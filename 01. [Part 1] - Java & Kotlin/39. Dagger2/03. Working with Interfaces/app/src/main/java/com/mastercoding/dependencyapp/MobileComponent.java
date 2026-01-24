package com.mastercoding.dependencyapp;

import dagger.Component;


// We need to link the module with component
@Component(modules = NickelBatteryModule.class)
public interface MobileComponent {
    Mobile getMobile();
}
