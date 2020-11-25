package com.smerkis.news.di

import com.smerkis.news.repo.NewsRepository
import com.smerkis.news.viewmodel.NewsViewModel
import com.smerkis.news.viewmodel.SearchViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NewsViewModel(get()) }
    viewModel { SearchViewModel(get()) }
}
