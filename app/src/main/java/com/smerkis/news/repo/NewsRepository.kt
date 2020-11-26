package com.smerkis.news.repo

import com.smerkis.news.api.NewsApi
import com.smerkis.news.model.NewsResponse
import com.smerkis.news.utils.Constants.Companion.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepository(
    private val newsApi: NewsApi,
) : NewsRepo {

    override suspend fun getNewsArticlesByCategory(category: String) = flow {
        emit(getTopHeadLinesForCategory(category).articles)
    }

    override suspend fun getTopHeadLinesForCategory(category: String): NewsResponse {
        return newsApi.getTopHeadLinesForCategory(category, "ru", API_KEY)
    }

    override suspend fun getSearchResult(searchRequest: String) = flow {
        emit(newsApi.getSearchResults(searchRequest, "publishedAt","ru", API_KEY).articles)
    }
}
