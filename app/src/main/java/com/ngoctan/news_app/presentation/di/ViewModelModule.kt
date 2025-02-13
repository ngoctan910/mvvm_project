package com.ngoctan.news_app.presentation.di

import com.ngoctan.news_app.presentation.ui.fragment.news.NewsViewModel


object ViewModelModule {
    val newsViewModel by lazy {
        NewsViewModel()
    }
}


