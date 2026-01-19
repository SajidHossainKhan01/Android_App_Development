package com.mastercoding.lma.di;

import android.app.Application;

import com.mastercoding.lma.model.CourseShopRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Singleton
    @Provides
    CourseShopRepository providesCourseShopRepository(Application application){
        return new CourseShopRepository(application);
    }
}
