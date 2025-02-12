package com.ngoctan.news_app.data.model.weather
data class MainObject(
    var temp: Double?,
    var feels_like: Double?,
    var temp_min: Double?,
    var temp_max: Double?,
    var pressure: Int?,
    var humidity: Int?,
    var sea_level: Int?,
    var grnd_level: Int?
)
