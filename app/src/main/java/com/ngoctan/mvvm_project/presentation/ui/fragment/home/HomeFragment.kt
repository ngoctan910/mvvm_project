package com.ngoctan.mvvm_project.presentation.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.ngoctan.mvvm_project.data.model.weather.Weather
import com.ngoctan.mvvm_project.data.network.ApiService
import com.ngoctan.mvvm_project.databinding.FragmentHomeBinding
import com.ngoctan.mvvm_project.presentation.di.ViewModelModule
import kotlinx.coroutines.launch

class HomeFragment: Fragment() {
    lateinit var binding: FragmentHomeBinding
    val viewModel = ViewModelModule.homeViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        lifecycleScope.launch {
            viewModel.weather.collect {
                binding.view.text = it?.name
            }
        }

        binding.btnClick.setOnClickListener {
            viewModel.currentWeather()
        }
    }
}