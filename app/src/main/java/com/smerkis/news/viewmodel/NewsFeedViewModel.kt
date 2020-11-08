package com.smerkis.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import androidx.paging.LivePagedListBuilder
import com.smerkis.news.datasource.NewsDataFactory
import com.smerkis.news.repo.NewsRepository
import com.smerkis.news.utils.pagedListConfig
import com.utsman.recycling.paged.extentions.NetworkState

class NewsFeedViewModel(repo: NewsRepository) : BaseViewModel() {

    private val newsDataSours = NewsDataFactory(repo, ioScope)

    val articles = LivePagedListBuilder(newsDataSours, pagedListConfig()).build()
    val networkState: LiveData<NetworkState> =
        Transformations.switchMap(newsDataSours.dataSource) { it.networkState }

    fun refreshAllList() =
        newsDataSours.getSource()?.refresh()



}