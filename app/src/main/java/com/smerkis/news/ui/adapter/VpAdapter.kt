package com.smerkis.news.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.smerkis.news.databinding.RvNewsFeedBinding
import com.smerkis.news.model.Article
import com.smerkis.news.utils.Constants

class VpAdapter(
    var loader: (String) -> Unit,
    var onClick: (Article) -> Unit
) :
    RecyclerView.Adapter<VpAdapter.Holder>() {
    interface LoaderNews {
        fun nextCategory(category: String)
    }

    val newsByCategory = HashMap<String, List<Article>>()

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
        val category = Constants.CATEGORIES[position]
        if (newsByCategory[category] == null) {
            loader(category)
        } else {
            ItemClickSupport.addTo(holder.binding.rv)
                .onItemClick(object : OnRecyclerViewItemClickListener {
                    override fun invoke(recyclerView: RecyclerView, position: Int, v: View) {
                        newsByCategory[category]?.get(position)?.let {
                            onClick(it)
                        }
                    }
                })
            holder.binding.rv.scheduleLayoutAnimation()
            holder.binding.rv.adapter =
                RvAdapter(newsByCategory[category]!!)
        }
    }

    class Holder(val binding: RvNewsFeedBinding) :
        RecyclerView.ViewHolder(binding.root) {
    }

}

