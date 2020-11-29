package com.smerkis.news.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smerkis.news.model.Article
import com.smerkis.news.repo.NewsRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


class NewsViewModel(private val repo: NewsRepo) : ViewModel() {

    val newsListLiveData: MutableLiveData<List<Article>> by lazy { MutableLiveData() }
    val errorData: MutableLiveData<Throwable> by lazy { MutableLiveData<Throwable>() }


    fun getNewsForCategory(category: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repo.getNewsArticlesByCategory(category).catch {
               errorData.postValue(it)
            }.collect {
                newsListLiveData.postValue(it)
            }
        }
    }
}