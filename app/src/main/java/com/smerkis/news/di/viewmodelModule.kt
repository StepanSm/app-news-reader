package com.smerkis.news.di

import com.smerkis.news.viewmodel.NewsFeedViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { NewsFeedViewModel(get()) }
}
