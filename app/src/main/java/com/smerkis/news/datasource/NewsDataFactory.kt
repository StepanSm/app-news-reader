package com.smerkis.news.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.repo.NewsRepository
import kotlinx.coroutines.CoroutineScope

class NewsDataFactory(
    private val newsRepository: NewsRepository,
    private val scope: CoroutineScope
) : DataSource.Factory<Int, ArticleStructure>() {

    val dataSource = MutableLiveData<NewsDataSours>()

    override fun create(): DataSource<Int, ArticleStructure> {
        val data = NewsDataSours(newsRepository, scope)
        dataSource.postValue(data)
        return data
    }

    fun getSource() = dataSource.value




}