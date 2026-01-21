package com.mastercoding.roomapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

// provides methods for querying/retrieving, inserting, deleting
// and updating the database.

@Dao
interface ItemDao {

    @Insert
    suspend fun insertItem(item: Item)

    @Delete
    suspend fun deleteItem(item: Item)

    @Update
    suspend fun updateItem(item: Item)

    @Query("DELETE FROM Item")
    fun deleteAllItems()

    @Query("SELECT * FROM Item")
    fun getAllItemsInDB(): LiveData<List<Item>>

}