package com.ngoctan.mvvm_project.presentation.ui.fragment.weather

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ngoctan.mvvm_project.databinding.FragmentWeatherBinding
import com.ngoctan.mvvm_project.presentation.di.ViewModelModule
import kotlinx.coroutines.launch

class WeatherFragment: Fragment() {
    lateinit var binding: FragmentWeatherBinding
    val viewModel = ViewModelModule.homeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWeatherBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.weather.collect {
                binding.edtCity.setText(it?.name)
                binding.tvCity.text = it?.name
                binding.city.text = it?.name
                binding.tvCountry.text = it?.sys?.country
                binding.tvTemperature.text = it?.main?.temp?.toString()
            }
        }

        binding.ivSearch.setOnClickListener {
            viewModel.currentWeather(binding.edtCity.text.toString())
        }
    }
}