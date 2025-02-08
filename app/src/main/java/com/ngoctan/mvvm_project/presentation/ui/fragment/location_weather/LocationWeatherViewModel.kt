package com.ngoctan.mvvm_project.presentation.ui.fragment.location_weather

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngoctan.mvvm_project.data.model.weather.Weather
import com.ngoctan.mvvm_project.presentation.di.AppRepositoryModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationWeatherViewModel: ViewModel() {
    private val appRepository = AppRepositoryModule.appRepository
    private var _locationWeather: MutableStateFlow<Weather?> = MutableStateFlow(null)
    val locationWeather: StateFlow<Weather?> = _locationWeather

    fun getLocationWeather(lat: String, lon: String) {
        viewModelScope.launch {
            appRepository.getLocationWeather(lat, lon).collect { weather ->
                _locationWeather.value = weather
            }
        }
    }
}