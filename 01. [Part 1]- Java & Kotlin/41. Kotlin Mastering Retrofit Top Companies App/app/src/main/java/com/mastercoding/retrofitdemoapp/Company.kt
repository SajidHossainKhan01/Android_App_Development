package com.mastercoding.retrofitdemoapp

import com.google.gson.annotations.SerializedName

// data class: used for holding data (POJO)

data class Company(
    val name: String,
    val countryCode:String,


    // 'marketCap' corresponds
    // to "market_cap" in JSON
    @SerializedName("market_cap")
    val marketCap:Double,
    val id: Int
)
