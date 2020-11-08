package com.smerkis.news.di

import com.smerkis.news.repo.NewsRepository
import org.koin.dsl.module

val repositoryModule = module {
    single { NewsRepository(get()) }
}