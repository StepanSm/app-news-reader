package com.smerkis.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import android.view.animation.Transformation
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import coil.transform.CircleCropTransformation
import com.smerkis.news.MyApp
import com.smerkis.news.R
import com.smerkis.news.databinding.ItemArticleBinding
import com.smerkis.news.model.Article
import com.smerkis.news.ui.MainFragment
import com.smerkis.news.ui.adapter.ItemClickSupport.Companion.addTo
import kotlinx.coroutines.Dispatchers

class RvAdapter(private var newsList: List<Article>) :
    RecyclerView.Adapter<RvAdapter.Holder>() {

    override fun getItemCount() = newsList.size
    private var lastPosition = -1

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            ItemArticleBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onViewDetachedFromWindow(holder: Holder) {
        super.onViewDetachedFromWindow(holder)
        holder.itemView.clearAnimation()
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.binding.apply {
            tv.text = newsList[position].title
            img.load(newsList[position].urlToImage) {
                placeholder(R.drawable.ic_placeholder)
                error(R.drawable.ic_placeholder)
                scale(Scale.FILL)
                dispatcher(Dispatchers.IO)
            }
            val animation = AnimationUtils.loadAnimation(
                MyApp.instance,
                if (position > lastPosition) R.anim.up_from_bottom else R.anim.down_from_top
            )
            container.startAnimation(animation)
            lastPosition = position
        }
    }

    class Holder(val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun updateList(news: List<Article>) {
        val diffResult = DiffUtil.calculateDiff(BooksDiffCallback(newsList, news), false)
        newsList = news
        diffResult.dispatchUpdatesTo(this)
    }
}

class BooksDiffCallback(
    private val oldBooksList: List<Article>?,
    private val newBooksList: List<Article>?
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