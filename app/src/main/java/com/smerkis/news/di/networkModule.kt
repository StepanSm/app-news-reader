package com.smerkis.news.di

import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.smerkis.news.MyApp
import com.smerkis.news.api.NewsApi
import com.smerkis.news.api.interceptors.OfflineResponseCacheInterceptor
import com.smerkis.news.api.interceptors.ResponseCacheInterceptor
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

private const val CONNECT_TIMEOUT = 10L
private const val BASE_URL = "https://newsapi.org/v2/"

val networkModule = module {

    single { GsonBuilder().create() }

    single {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
        httpLoggingInterceptor.level = HttpLoggingInterceptor.Level.BASIC
        OkHttpClient.Builder().apply {
            addNetworkInterceptor(ResponseCacheInterceptor())
            connectTimeout(CONNECT_TIMEOUT, TimeUnit.SECONDS)
            readTimeout(60, TimeUnit.SECONDS)
            addInterceptor(OfflineResponseCacheInterceptor())
            cache(Cache(File(MyApp.instance.cacheDir, "ResponsesCache"), 10 * 1024 * 1024))
            retryOnConnectionFailure(true)
            addInterceptor(httpLoggingInterceptor)
        }.build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(get()))
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .client(get())
            .build()
    }

    //NewsApi
    single { get<Retrofit>().create(NewsApi::class.java) }
}