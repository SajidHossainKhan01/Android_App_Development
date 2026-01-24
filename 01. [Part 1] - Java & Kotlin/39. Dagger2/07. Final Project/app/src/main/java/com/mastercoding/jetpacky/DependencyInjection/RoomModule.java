package com.mastercoding.jetpacky.DependencyInjection;

import android.app.Application;

import androidx.room.Room;

import com.mastercoding.jetpacky.ContactAppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    @Provides
    @Singleton
    ContactAppDatabase provideContactAppDatabase(Application application){
        return Room.databaseBuilder(
                application,
                ContactAppDatabase.class,
                "ContactDB"
        )  .allowMainThreadQueries()
                .build();
    }
}

