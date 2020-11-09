package com.smerkis.news.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.CoroutineDataSource
import androidx.paging.DataSource
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.repo.NewsRepository
import kotlinx.coroutines.CoroutineScope

class NewsDataFactory(
    private val newsRepository: NewsRepository,
) : CoroutineDataSource.Factory<Int, ArticleStructure>() {

    val dataSource = MutableLiveData<NewsDataSours>()

    override fun create(): DataSource<Int, ArticleStructure> {
        val data = NewsDataSours(newsRepository)
        dataSource.postValue(data)
        return data
    }

}