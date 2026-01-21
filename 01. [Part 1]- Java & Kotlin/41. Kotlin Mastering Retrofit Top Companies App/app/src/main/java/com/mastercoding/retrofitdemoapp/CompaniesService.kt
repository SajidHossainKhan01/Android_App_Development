package com.mastercoding.retrofitdemoapp

import retrofit2.Response
import retrofit2.http.GET

interface CompaniesService {

    // defines methods for making API requests related to Companies
    // Specify the End-Points of the URL

    // Response: encapsulates the HTTP response received from the
    // server, including status codes, headers, & response body.

    @GET("/companies")
    suspend fun getAllCompanies(): Response<CompaniesList>

}