package com.smerkis.news.ui

import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.smerkis.news.R
import com.smerkis.news.databinding.CardRowBinding
import com.smerkis.news.databinding.FragmentNewsFeedBinding
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.viewmodel.NewsFeedViewModel
import com.utsman.recycling.paged.setupAdapterPaged
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFeedFragment : Fragment(R.layout.fragment_news_feed),
    SwipeRefreshLayout.OnRefreshListener {

    private val viewBinding: FragmentNewsFeedBinding by viewBinding(FragmentNewsFeedBinding::bind)
    private val model: NewsFeedViewModel by viewModel()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewBinding.swipeRefreshLayout.setOnRefreshListener(this)



        viewBinding.recyclerView.setupAdapterPaged<ArticleStructure>(R.layout.card_row) { adapter, context, list ->

            bind { itemView, _, item ->
                val binding = DataBindingUtil.bind<CardRowBinding>(itemView)
                binding?.article = item
            }

            val layoutManager = LinearLayoutManager(context)
            setLayoutManager(layoutManager)

            addLoader(R.layout.loader_layout) {
                idLoader = R.id.progress_circular
                idTextError = R.id.error_text_view
            }

            model.getCuratedPhoto().observe(viewLifecycleOwner) {
                viewBinding.swipeRefreshLayout.isRefreshing = false
                submitList(it)
            }

            model.getLoader().observe(viewLifecycleOwner) {
                viewBinding.swipeRefreshLayout.isRefreshing = false
                submitNetwork(it)
            }
        }
    }

    override fun onRefresh() {
    }


}