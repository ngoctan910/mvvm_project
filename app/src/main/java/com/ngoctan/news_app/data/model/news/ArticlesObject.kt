package com.ngoctan.news_app.data.model.news

data class ArticlesObject(
    var source: SourceObject,
    var author: String,
    var title: String,
    var description: String,
    var url: String,
    var urlToImage: String,
    var publishedAt: String,
    var content: String,
)
