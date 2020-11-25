package com.smerkis.news.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.repo.NewsRepo
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel(private val repo: NewsRepo) : ViewModel() {

    val searchListResult: MutableLiveData<List<ArticleStructure>> by lazy { MutableLiveData() }
    val errorData: MutableLiveData<Throwable> by lazy { MutableLiveData<Throwable>() }

    fun getSearchResult(searchRequest: String) {

        viewModelScope.launch {
            repo.getSearchResult(searchRequest).catch {
                errorData.value = it
            }.collect {
                searchListResult.value = it
            }
        }

    }
}