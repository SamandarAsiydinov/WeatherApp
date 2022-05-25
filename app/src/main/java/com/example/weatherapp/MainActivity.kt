package com.example.weatherapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.viewmode.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initViews()

    }
    private fun initViews() {
        viewModel.response.observe(this) { weather ->
            binding.apply {
                tvCityName.text = "Uzbekistan"
                tvDescription.text = weather.description
                tvTemperature.text = weather.temperature
                tvWind.text = weather.wind

                val forecast1 = weather.forecast[0]
                val forecast2 = weather.forecast[0]
                val forecast3 = weather.forecast[0]

                tvForecast1.text = "${forecast1.temperature} / ${forecast1.wind}"
                tvForecast2.text = "${forecast2.temperature} / ${forecast2.wind}"
                tvForecast3.text = "${forecast3.temperature} / ${forecast3.wind}"
            }
        }
    }
}