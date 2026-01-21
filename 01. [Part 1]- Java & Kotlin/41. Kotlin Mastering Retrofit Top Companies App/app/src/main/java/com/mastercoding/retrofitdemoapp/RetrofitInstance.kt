package com.mastercoding.retrofitdemoapp

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInstance {

    // This class provides us with Retrofit Instance


    companion object{
        // Methods & Members inside this block can be accessed
        // using the class name

        val BASE_URL = "https://testapi.devtoolsdaily.com"

        fun getRetrofitInstance():Retrofit{
            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(
                    GsonBuilder().create()
                )).build()
        }
    }
}