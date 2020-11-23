package com.smerkis.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.smerkis.news.databinding.ItemArticleBinding
import com.smerkis.news.model.ArticleStructure

class RvAdapter(private var newsList: List<ArticleStructure>) : RecyclerView.Adapter<RvAdapter.Holder>() {


    override fun getItemCount() = newsList.size


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            tvCardMainTitle.text = newsList[position].title
            imgCardMain.load(newsList[position].urlToImage)
        }
    }

    inner class Holder(val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun updateList(news: List<ArticleStructure>) {
//        val diffResult = DiffUtil.calculateDiff(BooksDiffCallback(mNewsList, news), false)
        newsList = news
//        diffResult.dispatchUpdatesTo(this)
        notifyDataSetChanged()
    }
}

class BooksDiffCallback(
    private val oldBooksList: List<ArticleStructure>?,
    private val newBooksList: List<ArticleStructure>?
) : DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldBooksList?.get(oldItemPosition)?.title == newBooksList?.get(newItemPosition)?.title
    }

    override fun getOldListSize(): Int {
        return oldBooksList?.size ?: 0
    }

    override fun getNewListSize(): Int {
        return newBooksList?.size ?: 0
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldBooksList?.get(oldItemPosition)?.equals(newBooksList?.get(newItemPosition))!!
    }
}