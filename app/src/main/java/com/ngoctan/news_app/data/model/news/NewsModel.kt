package com.ngoctan.news_app.data.model.news

data class NewsModel (
    var status: String,
    var totalResults: Int,
    var articles: List<ArticlesObject>
)