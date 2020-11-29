package com.smerkis.news.utils

import android.content.Context
import android.net.ConnectivityManager
import com.smerkis.news.MyApp

fun isNetworkAvailable(): Boolean {
    val connectivityManager =
        MyApp.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnectedOrConnecting
}
