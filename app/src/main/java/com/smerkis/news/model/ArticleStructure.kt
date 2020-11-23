package com.smerkis.news.model

import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey


const val tableName = "news_article"

@Entity(tableName = tableName)
data class ArticleStructure(
    @Ignore
    val source: Source,
    var author: String?,
    @PrimaryKey
    var title: String,
    var description: String?,
    var url: String?,
    var urlToImage: String?,
    var publishedAt: String?,
    var content: String?,
    var category: String? = source.category
) {
    constructor() : this(Source("", "", "", "", "", "", ""), "", "", "", "", "", "", "")
}

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleStructure>
)


data class Source(
    val id: String?,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String
)

data class SourcesResponse(
    val status: String,
    val sources: List<Source>
)


