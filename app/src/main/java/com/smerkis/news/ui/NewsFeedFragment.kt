package com.smerkis.news.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.smerkis.news.R
import com.smerkis.news.api.NetworkState
import com.smerkis.news.databinding.FragmentNewsFeedBinding
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.ui.adapter.NewsFeedAdapter
import com.smerkis.news.viewmodel.NewsFeedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class NewsFeedFragment : Fragment(R.layout.fragment_news_feed),
    SwipeRefreshLayout.OnRefreshListener, NewsFeedAdapter.OnClickListener {

    private val adapter = NewsFeedAdapter(this)
    private val viewBinding: FragmentNewsFeedBinding by viewBinding(FragmentNewsFeedBinding::bind)
    private val model: NewsFeedViewModel by viewModel()
    private var lastPosition = -1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecyclerView()
        observeViewModelData()
    }


    private fun setupRecyclerView() {
        viewBinding.recyclerView.adapter = adapter
        viewBinding.swipeRefreshLayout.setOnRefreshListener(this)
        viewBinding.swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
        viewBinding.swipeRefreshLayout.isRefreshing = true
    }


    private fun observeViewModelData() {
        model.networkState?.observe(viewLifecycleOwner) { adapter.updateNetworkState(it) }
        model.articles.observe(viewLifecycleOwner) { articles ->
            adapter.submitList(articles)
            viewBinding.swipeRefreshLayout.isRefreshing = false
        }
    }

    override fun onRefresh() {
        viewBinding.swipeRefreshLayout.isRefreshing = true
    }

    override fun onRetryClick() {
        TODO("Not yet implemented")
    }

    override fun whenListIsUpdated(size: Int, networkState: NetworkState?) {
        TODO("Not yet implemented")
    }

    override fun onArticleRowClicked(article: ArticleStructure) {
        article.apply {
            findNavController().navigate(
                NewsFeedFragmentDirections.actionNewsFeedFragmentToArticleFragment(
                    title,
                    description,
                    publishedAt,
                    urlToImage,
                    url,
                    author ?: "",
                    content ?: ""
                )
            )
        }
    }
}
