package com.ngoctan.news_app.presentation.di

import com.ngoctan.news_app.data.repository.AppRepositoryImp
import com.ngoctan.news_app.domain.reponsitory.AppRepository

object AppRepositoryModule {
    val appRepository: AppRepository by lazy {
        AppRepositoryImp()
    }
}