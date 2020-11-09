package com.smerkis.news.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.CoroutinePageKeyedDataSource
import com.smerkis.news.api.NetworkState
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.repo.NewsRepository
import com.smerkis.news.utils.logi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsDataSours(
    private val repository: NewsRepository,
) : CoroutinePageKeyedDataSource<Int, ArticleStructure>() {

    val networkState = MutableLiveData<NetworkState>()


    override suspend fun loadAfter(params: LoadParams<Int>): LoadResult<Int, ArticleStructure> {
        lateinit var retVal: LoadResult<Int, ArticleStructure>;
        this.coroutineScope.launch(Dispatchers.IO) {
            retVal = try {
                networkState.postValue(NetworkState.RUNNING)
                val result = repository.getHeadlines(params.key, params.requestedLoadSize)
                networkState.postValue(NetworkState.SUCCESS)
                LoadResult.Success(result.articles, params.key + 1)
            } catch (e: Exception) {
                logi("loadAfter ${params.key}")
                networkState.postValue(NetworkState.FAILED)
                //you should notify user
                LoadResult.Error(e)
            }
        }.join()
        return retVal
    }

    override suspend fun loadBefore(params: LoadParams<Int>): LoadResult<Int, ArticleStructure> {
        return LoadResult.None

    }

    override suspend fun loadInitial(params: LoadInitialParams<Int>): InitialResult<Int, ArticleStructure> {
        return try {
            networkState.postValue(NetworkState.RUNNING)
            val result = repository.getHeadlines(1, params.requestedLoadSize)
            networkState.postValue(NetworkState.SUCCESS)
            InitialResult.Success(result.articles, 0, result.totalResults, 1, 2)
        } catch (e: Exception) {
            // you should notify user
            networkState.postValue(NetworkState.FAILED)
            InitialResult.Error(e)
        }

    }

}
