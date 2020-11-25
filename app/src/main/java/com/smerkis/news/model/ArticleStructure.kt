package com.smerkis.news.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize


const val tableName = "news_article"
@Parcelize
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
): Parcelable {
    constructor() : this(Source("", "", "", "", "", "", ""), "", "", "", "", "", "", "")
}

data class NewsResponse(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticleStructure>
)

@Parcelize
data class Source(
    val id: String?,
    val name: String,
    val description: String,
    val url: String,
    val category: String,
    val language: String,
    val country: String
): Parcelable

data class SourcesResponse(
    val status: String,
    val sources: List<Source>
)


