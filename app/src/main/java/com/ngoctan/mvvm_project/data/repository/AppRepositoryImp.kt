package com.ngoctan.mvvm_project.data.repository

import com.google.gson.Gson
import com.ngoctan.mvvm_project.application.MainApplication
import com.ngoctan.mvvm_project.data.model.story.StoryModel
import com.ngoctan.mvvm_project.data.model.weather.Weather
import com.ngoctan.mvvm_project.data.network.RetrofitClient
import com.ngoctan.mvvm_project.domain.reponsitory.AppRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

class AppRepositoryImp: AppRepository {
    val apiService = RetrofitClient.apiService
    val context = MainApplication.getInstance().applicationContext

    override fun getWeather(city: String): Flow<Weather> = flow {
        val response = apiService.getWeather(city, "5b14bf48d1725eec39f8fc50ce94680c"
                                            ,"metric")
        if (response.isSuccessful) {
            response.body()?.let { weather ->
                emit(weather)
            }
        }
    }

    override fun getStories(): Flow<StoryModel> = flow {
        try {
            val result = context.assets.open("stories.txt").bufferedReader().use {
                it.readText()
            }

            val gsonStoryModel = Gson().fromJson(result, StoryModel::class.java)
            emit(gsonStoryModel)

        } catch (e: IOException) {
            e.printStackTrace()
        }
    }.flowOn(Dispatchers.IO)


}