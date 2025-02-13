package com.ngoctan.news_app.domain.reponsitory

import com.ngoctan.news_app.data.model.news.NewsModel
import kotlinx.coroutines.flow.Flow

interface AppRepository {
    fun getNews(): Flow<NewsModel>
}