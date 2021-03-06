package com.smerkis.news.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.smerkis.news.model.Article
import com.smerkis.news.repo.NewsRepo
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SearchViewModel(private val repo: NewsRepo) : ViewModel() {

    val errorData: MutableLiveData<Throwable> by lazy { MutableLiveData<Throwable>() }

    fun getSearchResult(searchRequest: String, page: Int): LiveData<List<Article>?> {

        val newList: MutableLiveData<List<Article>?> = MutableLiveData()

        viewModelScope.launch {
            repo.getSearchResult(searchRequest, page).catch {
                errorData.value = it
            }.collect {
                newList.postValue(it)
            }
        }
        return newList
    }
}
