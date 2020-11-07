package com.smerkis.news.utils

import android.content.Context
import android.text.TextUtils
import android.util.Log
import android.widget.ImageView
import android.widget.Toast
import androidx.databinding.BindingAdapter
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import coil.load
import coil.request.CachePolicy

fun Any.logi(msg: String) = Log.i(this.javaClass.simpleName, msg)
fun Any.loge(msg: String) = Log.e(this.javaClass.simpleName, msg)

fun Context.toast(msg: String) = Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()

inline fun FragmentManager.inTransaction(func: FragmentTransaction.() -> FragmentTransaction) =
    beginTransaction().func().commit()

@BindingAdapter(value = ["avatarUrl"])
fun loadImage(view: ImageView, imageUrl: String?){

    if(!TextUtils.isEmpty(imageUrl))
        view.load(imageUrl) {
            crossfade(true)
            memoryCachePolicy(CachePolicy.DISABLED)
        }
}