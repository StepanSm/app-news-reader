package com.smerkis.news.utils

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.paging.PagedList

fun Any.logi(msg: String) = Log.i(this.javaClass.simpleName, msg)
fun Any.loge(msg: String) = Log.e(this.javaClass.simpleName, msg)

fun Context.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
fun Fragment.toast(msg: String) = Toast.makeText(this.activity, msg, Toast.LENGTH_SHORT).show()

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

fun pagedListConfig() = PagedList.Config.Builder()
    .setInitialLoadSizeHint(5)
    .setEnablePlaceholders(false)
    .setPageSize(20)
    .build()