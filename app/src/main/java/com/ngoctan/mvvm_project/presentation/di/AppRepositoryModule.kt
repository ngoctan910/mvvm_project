package com.ngoctan.mvvm_project.presentation.di

import com.ngoctan.mvvm_project.data.repository.AppRepositoryImp
import com.ngoctan.mvvm_project.domain.reponsitory.AppRepository

object AppRepositoryModule {
    val appRepository: AppRepository by lazy {
        AppRepositoryImp()
    }
}
