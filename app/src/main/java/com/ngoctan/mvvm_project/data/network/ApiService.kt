package com.ngoctan.mvvm_project.data.network

import com.ngoctan.mvvm_project.data.model.weather.Weather
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getWeather(@Query("q") cityName: String, @Query("appid") id: String,
                    @Query("units") units: String): Response<Weather>
}
