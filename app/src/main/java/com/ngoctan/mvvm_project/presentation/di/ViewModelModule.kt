package com.ngoctan.mvvm_project.presentation.di

import com.ngoctan.mvvm_project.presentation.ui.fragment.home.HomeViewModel

object ViewModelModule {
    val homeViewModel by lazy {
        HomeViewModel()
    }
}