package com.smerkis.news.repo

import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.model.NewsResponse
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface NewsRepo {

    suspend fun getNewsArticlesByCategory(category: String): Flow<List<ArticleStructure>>

    suspend fun getTopHeadLinesForCategory(category: String): NewsResponse

    suspend fun getSearchResult(searchRequest: String): Flow<List<ArticleStructure>>

}