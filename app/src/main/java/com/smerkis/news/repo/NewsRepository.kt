package com.smerkis.news.repo

import com.smerkis.news.api.NewsApi
import com.smerkis.news.model.NewsResponse
import com.smerkis.news.utils.Constants.Companion.API_KEY
import com.smerkis.news.utils.Constants.Companion.SOURCE_ARRAY
import com.smerkis.news.utils.logi

class NewsRepository(private val newsApi: NewsApi) {


    suspend fun getHeadlines(page: Int, perPage: Int): NewsResponse {
        val d = newsApi.getHeadlines( page, perPage, API_KEY, SOURCE_ARRAY[10]).await()
        logi("getHeadlines ${d.totalResults}")
        return d

    }
}