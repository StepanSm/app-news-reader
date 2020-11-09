package com.smerkis.news.api

import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.model.NewsResponse
import com.smerkis.news.model.SourcesResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getHeadlinesAsync(
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): Deferred<NewsResponse>


    @GET("top-headlines")
    fun getHeadlinesAsync(
        @Query("page") page: Int,
        @Query("perPage") perPage: Int,
        @Query("sources") sources: String,
        @Query("apiKey") apiKey: String
    ): Deferred<NewsResponse>

    @GET("sources")
    fun getSourcesAsync(

        @Query("language") language: String,
        @Query("apiKey") apiKey: String
    ): Deferred<SourcesResponse>


    @GET("everything")
    fun getSearchResults(
        @Query("q") query: String,
        @Query("page") page: Long,
        @Query("perPage") perPage: Int,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String?
    ): Call<NewsResponse>

    @GET("everything")
    fun getSearchResults(
        @Query("q") query: String,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String?
    ): Deferred<NewsResponse>

//
//    @GET("everything")
//    fun getEverythingAsync(
//        @Query("page") page: Int,
//        @Query("perPage") perPage: Int,
//        @Query("language") language: String,
//        @Query("apiKey") apiKey: String?
//    ): Deferred<ArticleStructure>

    @GET("everything")
    fun getEverythingAsync(
        @Query("q") query: String,
        @Query("sortBy") sortBy: String,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String?
    ): Deferred<NewsResponse>
}

