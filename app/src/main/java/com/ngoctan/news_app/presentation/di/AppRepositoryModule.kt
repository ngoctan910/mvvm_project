package com.ngoctan.news_app.presentation.di

import com.ngoctan.news_app.data.repository.AppRepositoryImp
import com.ngoctan.news_app.data.repository.UserRepositoryImp
import com.ngoctan.news_app.domain.reponsitory.AppRepository
import com.ngoctan.news_app.domain.reponsitory.UserRepository

object AppRepositoryModule {
    val appRepository: AppRepository by lazy {
        AppRepositoryImp()
    }

    val userRepository: UserRepository by lazy {
        UserRepositoryImp()
    }


}
