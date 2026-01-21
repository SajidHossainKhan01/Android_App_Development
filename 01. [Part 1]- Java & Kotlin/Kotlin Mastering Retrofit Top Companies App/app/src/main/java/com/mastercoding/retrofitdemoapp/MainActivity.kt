package com.mastercoding.retrofitdemoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.liveData
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        resultTextView = findViewById(R.id.textView2)

        // Retrofit Instance
        val retrofitInstance = RetrofitInstance
            .getRetrofitInstance()
            .create(CompaniesService::class.java)

        // Live Data : Fetch Data Asynchronously
        val responseLiveData : LiveData<Response<CompaniesList>> =
            liveData {
                // Asynchronous operation is defined here

                val countriesResponse = retrofitInstance.getAllCompanies()
                emit(countriesResponse)

            }

        // Observing data changes in LiveData
        responseLiveData.observe(this, Observer {

            // execute this code when the LiveData's value changes
            val companiesList = it.body()?.listIterator()

            if (companiesList != null){
                while (companiesList.hasNext()){
                    val companyItem = companiesList.next()

                    val companiesResult = " Company Name: ${companyItem.name} \n"
                    resultTextView.append(companiesResult)
                }
            }

        })


    }
}