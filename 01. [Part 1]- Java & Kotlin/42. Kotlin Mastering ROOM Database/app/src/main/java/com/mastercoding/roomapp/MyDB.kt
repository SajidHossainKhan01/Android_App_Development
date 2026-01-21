package com.mastercoding.roomapp

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class MyDB : RoomDatabase() {

    // Getting a DAO instance
    abstract fun itemDAO(): ItemDao

    // Accessing the methods to create or get the Database
    companion object{
        // Singleton Pattern
        @Volatile
        private var Instance: MyDB? = null

        // if the Instance is not null, return it
        // otherwise create a new database instance
        fun getDatabase(context: Context): MyDB{
            return Instance ?:  synchronized(this){
                Room.databaseBuilder(
                    context,
                    MyDB::class.java,
                    "item_database"
                ).build()
                    .also { Instance = it }
            }

        }

    }

}