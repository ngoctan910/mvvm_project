package com.ngoctan.news_app.data.network

import com.ngoctan.news_app.data.model.news.NewsModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("v2/top-headlines")
    suspend fun getNews(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): Response<NewsModel>
}