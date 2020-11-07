package com.smerkis.news.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.smerkis.news.model.ArticleStructure

class NewsDataFactory : DataSource.Factory<Long, ArticleStructure>() {

    val pagingLiveData = MutableLiveData<NewsDataSours>()

    override fun create(): DataSource<Long, ArticleStructure> {
        val data = NewsDataSours()
        pagingLiveData.postValue(data)
        return data
    }
}