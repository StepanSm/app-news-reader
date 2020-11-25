package com.smerkis.news.utils

import android.content.Context
import android.net.ConnectivityManager
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.smerkis.news.MyApp


fun Any.logi(msg: String) = Log.i(this.javaClass.simpleName, msg)
fun Any.loge(msg: String) = Log.e(this.javaClass.simpleName, msg)

fun Context.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
fun Fragment.toast(msg: String) = Toast.makeText(this.activity, msg, Toast.LENGTH_SHORT).show()

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()


fun isNetworkAvailable(): Boolean {
    val connectivityManager =
        MyApp.instance.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    return connectivityManager.activeNetworkInfo != null && connectivityManager.activeNetworkInfo!!.isConnectedOrConnecting
}
