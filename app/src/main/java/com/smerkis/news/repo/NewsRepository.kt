package com.smerkis.news.repo

import com.smerkis.news.api.NewsApi
import com.smerkis.news.data.storage.NewsArticleDao
import com.smerkis.news.model.NewsResponse
import com.smerkis.news.utils.Constants.Companion.API_KEY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class NewsRepository(
    private val newsApi: NewsApi,
    private val newsArticleDao: NewsArticleDao,
) : NewsRepo {

    override suspend fun getNewsArticlesByCategory(category: String) = flow {

        val fromServer = getTopHeadLinesForCategory(category)

        fromServer.articles.let { newsArticleDao::insert }

        val cacheNews = newsArticleDao.getAllArticlesForCategory(category)

        emit(fromServer.articles)

    }

    override suspend fun getTopHeadLinesForCategory(category: String): NewsResponse {
        return newsApi.getTopHeadLinesForCategory(category, "ru", API_KEY)
    }
}