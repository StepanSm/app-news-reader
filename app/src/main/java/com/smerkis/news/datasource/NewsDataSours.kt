package com.smerkis.news.datasource

import androidx.lifecycle.MutableLiveData
import androidx.paging.PageKeyedDataSource
import com.smerkis.news.ApiClient
import com.smerkis.news.BuildConfig
import com.smerkis.news.api.ApiInterface
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.model.NewsResponse
import com.smerkis.news.utils.loge
import com.smerkis.news.utils.logi
import com.utsman.recycling.paged.extentions.NetworkState
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private const val SOURCE = "the-times-of-india"
private const val SORT_BY = "publishedAt"
private const val API_KEY = BuildConfig.API_KEY


@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class NewsDataSours : PageKeyedDataSource<Long, ArticleStructure>() {

    var networkState = MutableLiveData<NetworkState>()
    //  private var page = 1


    override fun loadInitial(
        params: LoadInitialParams<Long>,
        callback: LoadInitialCallback<Long, ArticleStructure>
    ) {
        networkState.postValue(NetworkState.LOADING)

        val request = ApiClient.client.create(ApiInterface::class.java)
        request.getSearchResults("vote", 1, SORT_BY, "en", API_KEY)
            .enqueue(object : Callback<NewsResponse> {

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    loge(t.localizedMessage)
                    networkState.postValue(NetworkState.error(t.localizedMessage))
                }

                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    val body = response.body()
                    if (body != null) {
                        logi("eeeeee -- ${body.articles}")
                        networkState.postValue(NetworkState.LOADED)
                        logi("aaaaaa -> ${body.articles[0]}")
                        callback.onResult(body.articles, null, 2)
                    }
                }
            })
    }

    override fun loadAfter(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, ArticleStructure>
    ) {
        val page = params.key
        val request = ApiClient.client.create(ApiInterface::class.java)
        request.getSearchResults("vote", page, SORT_BY, "en", API_KEY)
            .enqueue(object : Callback<NewsResponse> {
                override fun onResponse(
                    call: Call<NewsResponse>,
                    response: Response<NewsResponse>
                ) {
                    val body = response.body()
                    if (body != null) {
                        networkState.postValue(NetworkState.LOADING)
                        callback.onResult(body.articles, page + 1)
                    }

                }

                override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                    loge(t.localizedMessage)
                    networkState.postValue(NetworkState.error(t.localizedMessage))
                }


            })
    }

    override fun loadBefore(
        params: LoadParams<Long>,
        callback: LoadCallback<Long, ArticleStructure>
    ) {
        TODO("Not yet implemented")
    }
}
