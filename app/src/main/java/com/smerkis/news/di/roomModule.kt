package com.smerkis.news.di

import com.smerkis.news.data.storage.NewsDatabase
import org.koin.dsl.module

val roomModule = module {
    single { NewsDatabase.getInstance(get()) }
    single { get<NewsDatabase>().newsArticlesDao() }

}