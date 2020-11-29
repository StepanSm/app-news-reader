package com.smerkis.news.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.size.Scale
import com.smerkis.news.R
import com.smerkis.news.databinding.ItemArticleBinding
import com.smerkis.news.model.Article
import kotlinx.coroutines.Dispatchers

class RvAdapter : RecyclerView.Adapter<RvAdapter.Holder>() {

    fun submitList(newsList: List<Article>) {
        this.newsList = newsList
        notifyDataSetChanged()
    }

    var newsList: List<Article> = ArrayList()
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
            if (position > lastPosition) {
                val animation =
                    AnimationUtils.loadAnimation(
                        holder.binding.container.context, R.anim.item_animation_fall_down
                    )
                holder.binding.container.startAnimation(animation)
                lastPosition = position
            }
        }
    }

    class Holder(val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root)
}
