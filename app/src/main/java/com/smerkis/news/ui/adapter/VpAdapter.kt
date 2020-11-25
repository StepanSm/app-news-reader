package com.smerkis.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smerkis.news.databinding.RvNewsFeedBinding
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.utils.Constants

class VpAdapter(var loader: LoaderNews) :
    RecyclerView.Adapter<VpAdapter.Holder>() {

    interface LoaderNews {
        fun nextCategory(category: String)
    }

    var news = ArrayList<ArticleStructure>()
    override fun getItemCount() = Constants.CATEGORIES.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            RvNewsFeedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        loader.nextCategory(Constants.CATEGORIES[position])
        //    holder.binding.rv.adapter = RvAdapter(news, loader as RvAdapter.ClickListener)
    }

    inner class Holder(binding: RvNewsFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}

