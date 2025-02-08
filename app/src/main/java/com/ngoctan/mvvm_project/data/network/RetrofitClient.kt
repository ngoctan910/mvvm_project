package com.ngoctan.mvvm_project.data.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {
    private const val BASE_URL = "https://api.openweathermap.org/data/2.5/"

     val retrofit: Retrofit by lazy {
         Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()
     }

    val apiService: ApiService by lazy {
        retrofit.create(ApiService::class.java)
    }

}

