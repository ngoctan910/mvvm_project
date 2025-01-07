package com.ngoctan.mvvm_project.presentation.di

import com.ngoctan.mvvm_project.presentation.ui.fragment.home.HomeViewModel
import com.ngoctan.mvvm_project.presentation.ui.fragment.user.UserViewModel

object ViewModelModule {
    val homeViewModel by lazy {
        HomeViewModel()
    }

    val userViewModel by lazy {
        UserViewModel()
    }
}