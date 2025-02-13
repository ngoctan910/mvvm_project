package com.ngoctan.news_app.presentation.ui.fragment.news

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ngoctan.news_app.data.model.news.NewsModel
import com.ngoctan.news_app.presentation.di.AppRepositoryModule
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class NewsViewModel: ViewModel() {
    private val appRepository = AppRepositoryModule.appRepository
    private var _news: MutableStateFlow<NewsModel?> = MutableStateFlow(null)
    val news: StateFlow<NewsModel?> = _news

    fun currentNews() {
        viewModelScope.launch {
            appRepository.getNews().collect { newsModel ->
                _news.value = newsModel
                Log.d("news", _news.toString())
            }
        }
    }
}