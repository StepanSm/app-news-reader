package com.smerkis.news.api

import com.smerkis.news.model.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    suspend fun getTopHeadLinesForCategory(
        @Query("category") category: String,
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse

    @GET("everything")
    suspend fun getSearchResults(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String,
        @Query("page") page: Int,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String
    ): NewsResponse
}

