package com.smerkis.news.model

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleStructure>
)

