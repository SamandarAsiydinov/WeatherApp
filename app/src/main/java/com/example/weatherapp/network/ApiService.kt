package com.example.weatherapp.network

import com.example.weatherapp.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("weather/Uzbekistan")
    suspend fun getWeather(): Response<Weather>
}