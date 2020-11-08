package com.smerkis.news.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.repo.NewsRepository
import com.utsman.recycling.paged.extentions.NetworkState
import kotlinx.coroutines.*


class NewsDataSours(
    private val repository: NewsRepository,
    private val scope: CoroutineScope
) : PageKeyedDataSource<Int, ArticleStructure>() {

    private val supervisorJob = SupervisorJob()
    val networkState = MutableLiveData<NetworkState>()

    override fun loadInitial(
        params: LoadInitialParams<Int>,
        callback: LoadInitialCallback<Int, ArticleStructure>
    ) {
        executeQuery(1, params.requestedLoadSize) {
            callback.onResult(it, null, 2)
        }
    }

    override fun loadAfter(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, ArticleStructure>
    ) {
        executeQuery(params.key, params.requestedLoadSize) {
            callback.onResult(it, params.key + 1)
        }
    }


    private fun executeQuery(page: Int, perPage: Int, callback: (List<ArticleStructure>) -> Unit) {
        networkState.postValue(NetworkState.LOADING)
        scope.launch(getJobErrorHandler() + supervisorJob) {
            val articles = repository.getHeadlines(page, perPage)
            networkState.postValue(NetworkState.LOADED)
            callback(articles.articles)
        }
    }

    private fun getJobErrorHandler() = CoroutineExceptionHandler { _, throwable ->
        networkState.postValue(NetworkState.error(throwable.message))
    }

    override fun loadBefore(
        params: LoadParams<Int>,
        callback: LoadCallback<Int, ArticleStructure>
    ) {
    }

    fun refresh() =
        this.invalidate()

    override fun invalidate() {
        super.invalidate()
        supervisorJob.cancelChildren()
    }
}
