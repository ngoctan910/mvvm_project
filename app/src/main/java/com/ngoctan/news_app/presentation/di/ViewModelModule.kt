package com.ngoctan.news_app.presentation.di

import com.ngoctan.news_app.presentation.ui.fragment.content.StoryContentViewModel
import com.ngoctan.news_app.presentation.ui.fragment.weather.WeatherViewModel
import com.ngoctan.news_app.presentation.ui.fragment.location_weather.LocationWeatherViewModel
import com.ngoctan.news_app.presentation.ui.fragment.story.StoryViewModel
import com.ngoctan.news_app.presentation.ui.fragment.topic.StoryTopicViewModel
import com.ngoctan.news_app.presentation.ui.fragment.user.UserViewModel

object ViewModelModule {
    val homeViewModel by lazy {
        WeatherViewModel()
    }

    val userViewModel by lazy {
        UserViewModel()
    }

    val storyTopicViewModel by lazy {
        StoryTopicViewModel()
    }

    val storyViewModel by lazy {
        StoryViewModel()
    }

    val storyContentViewModel by lazy {
        StoryContentViewModel()
    }

    val locationWeatherViewModel by lazy {
        LocationWeatherViewModel()
    }

}