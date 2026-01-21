package com.mastercoding.roomapp

import androidx.room.Entity
import androidx.room.PrimaryKey

// An entity class defines a table
// Each instance of this class represents a row in the DB table
// Each variable of this class represents a column

@Entity
data class Item(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,

    val name: String,
    val price: Double,
    val quantity: Int
)
