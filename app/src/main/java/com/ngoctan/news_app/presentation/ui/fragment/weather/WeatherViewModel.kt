package com.ngoctan.news_app.presentation.ui.fragment.weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngoctan.news_app.data.model.weather.Weather
import com.ngoctan.news_app.presentation.di.AppRepositoryModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class WeatherViewModel: ViewModel() {
    private val appRepository = AppRepositoryModule.appRepository
    private var _weather: MutableStateFlow<Weather?> = MutableStateFlow(null)
    val weather: StateFlow<Weather?> = _weather

    fun currentWeather(city: String) {
        viewModelScope.launch {
            appRepository.getWeather(city).collect { weather ->
                _weather.value = weather
            }
        }
    }

}