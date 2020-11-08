package com.smerkis.news.api

import com.smerkis.news.model.NewsResponse
import kotlinx.coroutines.Deferred
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getHeadlines(
        @Query("page") page: Int,
        @Query("perPage") perPage: Int,
        @Query("apiKey") apiKey: String,
        @Query("sources") vararg sources: String
    ): Deferred<NewsResponse>

    @GET("top-headlines")
    fun getHeadlines(
        @Query("page") page: Int,
        @Query("perPage") perPage: Int,
        @Query("apiKey") apiKey: String
    ): Deferred<NewsResponse>

    @GET("Everything")
    fun getCall(
        @Query("source") source: String,
        @Query("page") page: Int?,
        @Query("perPage") perPage: Int,

        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>


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
        @Query("page") page: Long,
        @Query("perPage") perPage: Int,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String?
    ): Deferred<NewsResponse>
}

