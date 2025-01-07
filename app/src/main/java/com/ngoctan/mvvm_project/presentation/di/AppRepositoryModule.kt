package com.ngoctan.mvvm_project.presentation.di

import com.ngoctan.mvvm_project.data.repository.AppRepositoryImp
import com.ngoctan.mvvm_project.data.repository.UserRepositoryImp
import com.ngoctan.mvvm_project.domain.reponsitory.AppRepository
import com.ngoctan.mvvm_project.domain.reponsitory.UserRepository

object AppRepositoryModule {
    val appRepository: AppRepository by lazy {
        AppRepositoryImp()
    }

    val userRepository: UserRepository by lazy {
        UserRepositoryImp()
    }
}
