package com.smerkis.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.smerkis.news.datasource.NewsDataFactory
import com.smerkis.news.model.ArticleStructure
import com.utsman.recycling.paged.extentions.NetworkState

class NewsFeedViewModel : ViewModel() {

    private var pagingDataFactory: NewsDataFactory? = null

    private fun configPaged(size: Int): PagedList.Config = PagedList.Config.Builder()
        .setPageSize(size)
        .setInitialLoadSizeHint(size * 2)
        .setEnablePlaceholders(true)
        .build()

    fun getCuratedPhoto(): LiveData<PagedList<ArticleStructure>> {
        pagingDataFactory = NewsDataFactory()
        return LivePagedListBuilder(pagingDataFactory!!, configPaged(4)).build()
    }

    fun getLoader(): LiveData<NetworkState> = Transformations.switchMap(
        pagingDataFactory?.pagingLiveData!!
    ) { it.networkState }


}