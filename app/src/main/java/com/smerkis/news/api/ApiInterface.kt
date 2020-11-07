package com.smerkis.news.api

import com.smerkis.news.model.NewsResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {

    @GET("top-headlines")
    fun getHeadlines(
        @Query("sources") sources: String,
        @Query("page") page: Int?,

        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>

    @GET("Everything")
    fun getCall(
        @Query("source") source: String,
        @Query("sortBy") sortBy: String,
        @Query("page") page: Int?,
        @Query("apiKey") apiKey: String
    ): Call<NewsResponse>


    @GET("everything")
    fun getSearchResults(
        @Query("q") query: String,
        @Query("page") page: Long,
        @Query("sortBy") sortBy: String,
        @Query("language") language: String,
        @Query("apiKey") apiKey: String?
    ): Call<NewsResponse>
}

