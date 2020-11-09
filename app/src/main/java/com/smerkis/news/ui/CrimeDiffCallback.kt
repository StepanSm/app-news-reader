package com.smerkis.news.ui

import androidx.recyclerview.widget.DiffUtil
import com.smerkis.news.model.ArticleStructure

class NewsDiffCallback(
    private val oldCrimeList: List<ArticleStructure>?,
    private val newCrimeList: List<ArticleStructure>?
) : DiffUtil.Callback() {

    override fun getOldListSize() =
        oldCrimeList?.size ?: 0

    override fun getNewListSize() =
        newCrimeList?.size ?: 0

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldCrimeList?.get(oldItemPosition)?.title == newCrimeList?.get(newItemPosition)?.title

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int) =
        oldCrimeList?.get(oldItemPosition)?.equals(newCrimeList?.get(newItemPosition))!!
}