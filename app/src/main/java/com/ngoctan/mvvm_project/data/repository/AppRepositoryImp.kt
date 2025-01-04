package com.ngoctan.mvvm_project.data.repository

import com.ngoctan.mvvm_project.data.model.weather.Weather
import com.ngoctan.mvvm_project.data.network.RetrofitClient
import com.ngoctan.mvvm_project.domain.reponsitory.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImp: AppRepository {
    val apiService = RetrofitClient.apiService

    override fun getWeather(): Flow<Weather> = flow {
        val response = apiService.getWeather("HaNoi", "5b14bf48d1725eec39f8fc50ce94680c"
                                            ,"metric")
        if (response.isSuccessful) {
            response.body()?.let { weather ->
                emit(weather)
            }
        }

    }


}