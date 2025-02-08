package com.ngoctan.mvvm_project.presentation.ui.fragment.location_weather

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.ngoctan.mvvm_project.databinding.FragmentLocationBinding
import com.ngoctan.mvvm_project.presentation.di.ViewModelModule
import kotlinx.coroutines.launch

class LocationWeatherFragment: Fragment() {
    lateinit var binding: FragmentLocationBinding
    val viewModel = ViewModelModule.locationWeatherViewModel
    private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLocationBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(requireActivity())

        if (ContextCompat.checkSelfPermission(requireContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            getLastKnownLocation()
        } else {
            ActivityCompat.requestPermissions(requireActivity(), arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1)
        }
    }

    private fun getLastKnownLocation() {
        if (ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED
            && ActivityCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED
            ) {
            return
        }

        fusedLocationClient.lastLocation.addOnSuccessListener { location ->
            location?.let { loc ->
                val latitude = loc.latitude
                val longitude = loc.longitude
                Log.d("location", latitude.toString())
                Log.d("location", longitude.toString())

                viewModel.getLocationWeather(latitude.toString(), longitude.toString())
            }
        }

        lifecycleScope.launch {
            viewModel.locationWeather.collect { location ->
                location?.let { loc ->
                    binding.city.text = loc.name.toString()
                    binding.latitude.text = loc.coord.lat.toString()
                    binding.longitude.text = loc.coord.lon.toString()
                }
            }
        }
    }
}