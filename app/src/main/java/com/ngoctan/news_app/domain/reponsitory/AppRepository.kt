package com.ngoctan.news_app.domain.reponsitory

import com.ngoctan.news_app.data.model.story.StoryModel
import com.ngoctan.news_app.data.model.weather.Weather
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getWeather(city: String): Flow<Weather>

    fun getStories(): Flow<StoryModel>

    fun getLocationWeather(lat: String, lon: String): Flow<Weather>
}