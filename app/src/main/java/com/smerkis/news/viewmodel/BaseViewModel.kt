package com.smerkis.news.viewmodel

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.cancel

abstract class BaseViewModel : ViewModel() {

    /**
     * Coroutines in a Main Thread
     */
    protected val mainScope = CoroutineScope(Dispatchers.Main)

    /**
     * Coroutines in a Pool of Thread
     */
    protected val ioScope = CoroutineScope(Dispatchers.IO)

    override fun onCleared() {
        super.onCleared()
        mainScope.coroutineContext.cancel()
        ioScope.coroutineContext.cancel()
    }
}