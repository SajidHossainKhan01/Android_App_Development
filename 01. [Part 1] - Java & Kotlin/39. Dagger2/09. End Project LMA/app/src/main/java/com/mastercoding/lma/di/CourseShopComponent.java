package com.mastercoding.lma.di;

import com.mastercoding.lma.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, RepositoryModule.class})
public interface CourseShopComponent {
    void inject(MainActivity mainActivity);
}
