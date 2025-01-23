package com.ngoctan.mvvm_project.domain.reponsitory

import com.ngoctan.mvvm_project.data.model.story.StoryModel
import com.ngoctan.mvvm_project.data.model.weather.Weather
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getWeather(city: String): Flow<Weather>

    fun getStories(): Flow<StoryModel>
}