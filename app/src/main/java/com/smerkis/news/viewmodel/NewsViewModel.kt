package com.smerkis.news.viewmodel

import androidx.lifecycle.*
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.repo.NewsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class NewsViewModel(private val repo: NewsRepo) : ViewModel() {

    val newsListLiveData: MutableLiveData<List<ArticleStructure>> by lazy { MutableLiveData() }
    val errorData: MutableLiveData<Throwable> by lazy { MutableLiveData<Throwable>() }
    val isDataLoaded: MutableLiveData<Boolean> by lazy { MutableLiveData<Boolean>() }


    fun getNewsForCategory(category: String = "") {
        isDataLoaded.value = false
        viewModelScope.launch(Dispatchers.IO) {
            repo.getNewsArticlesByCategory(category).catch {
                errorData.postValue(it)
            }.collect {
                newsListLiveData.postValue(it)
                isDataLoaded.postValue(true)
            }
        }
    }
}