package com.ngoctan.news_app.data.network

import com.ngoctan.news_app.data.model.weather.Weather
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("weather")
    suspend fun getWeather(@Query("q") cityName: String, @Query("appid") id: String,
                    @Query("units") units: String): Response<Weather>

    @GET("weather")
    suspend fun getLocationWeather(
        @Query("lat") latitude: String,
        @Query("lon") longitude: String,
        @Query("appid") id: String,
        @Query("units") units: String
    ): Response<Weather>
}
