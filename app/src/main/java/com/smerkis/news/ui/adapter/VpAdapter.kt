package com.smerkis.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.smerkis.news.databinding.FragmentNewsFeedBinding
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.ui.MainFragment
import com.smerkis.news.utils.Constants
import com.utsman.recycling.setupAdapter

class VpAdapter(var fragment: MainFragment?) :
    RecyclerView.Adapter<VpAdapter.Holder>() {

    var news = ArrayList<ArticleStructure>()
    override fun getItemCount() = Constants.CATEGORIES.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(
            FragmentNewsFeedBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        fragment?.nextCategory(Constants.CATEGORIES[position])
        holder.binding.recyclerView.setUpRecyclerView(RecyclerView.VERTICAL)
    }

    private fun RecyclerView.setUpRecyclerView(orientation: Int) {
        layoutManager = LinearLayoutManager(context, orientation, false)
        adapter = RvAdapter(news)
    }

    inner class Holder(val binding: FragmentNewsFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }
}

