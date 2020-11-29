package com.smerkis.news.repo

import com.smerkis.news.model.Article
import com.smerkis.news.model.NewsResponse
import kotlinx.coroutines.flow.Flow

interface NewsRepo {

    suspend fun getNewsArticlesByCategory(category: String): Flow<List<Article>>

    suspend fun getTopHeadLinesForCategory(category: String): NewsResponse

    suspend fun getSearchResult(searchRequest: String, page: Int): Flow<List<Article>>

}