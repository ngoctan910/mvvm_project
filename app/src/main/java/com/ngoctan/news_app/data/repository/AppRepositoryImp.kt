package com.ngoctan.news_app.data.repository

import android.util.Log
import com.ngoctan.news_app.data.model.news.NewsModel
import com.ngoctan.news_app.data.network.RetrofitClient
import com.ngoctan.news_app.domain.reponsitory.AppRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class AppRepositoryImp: AppRepository {
    val apiService = RetrofitClient.apiService

    override fun getNews(): Flow<NewsModel> = flow {
        val response = apiService.getNews("techcrunch", "5230f46ffd4c4190a99018793afda7b6")

        if (response.isSuccessful) {
            response.body()?.let { newsModel ->
                Log.d("news", newsModel.toString())
                emit(newsModel)
            }
        }
    }
}