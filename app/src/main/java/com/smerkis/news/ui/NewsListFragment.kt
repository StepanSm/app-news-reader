package com.smerkis.news.ui

import android.os.Bundle
import android.view.View
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import by.kirich1409.viewbindingdelegate.viewBinding
import com.smerkis.news.BaseFragment
import com.smerkis.news.R
import com.smerkis.news.databinding.RvNewsFeedBinding
import com.smerkis.news.ui.adapter.RvAdapter
import com.smerkis.news.ui.adapter.onItemClick
import com.smerkis.news.utils.isNetworkAvailable
import com.smerkis.news.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.androidx.viewmodel.ext.android.viewModel


class NewsListFragment : BaseFragment(R.layout.rv_news_feed), SwipeRefreshLayout.OnRefreshListener {

    private val vModel: NewsViewModel by viewModel()
    private val binding: RvNewsFeedBinding by viewBinding(RvNewsFeedBinding::bind)
    private var category = ""

    companion object {
        fun newInstance(category: String): NewsListFragment {
            val fragment = NewsListFragment()
            fragment.arguments = Bundle().apply {
                putString("category", category)
            }
            return fragment
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        category = arguments?.getString("category") ?: ""
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupRecycle()
    }

    private fun setupRecycle() {
        val rvAdapter = RvAdapter()
        binding.apply {
            swipeRefresh.isRefreshing = true
            swipeRefresh.setOnRefreshListener(this@NewsListFragment)
            rv.adapter = rvAdapter
            rv.onItemClick { _, position, _ ->
                navigate(MainFragmentDirections.actionMainFragmentToArticleFragment(rvAdapter.newsList[position]))
            }
        }
        vModel.getNewsForCategory(category)
        vModel.newsListLiveData.observe(viewLifecycleOwner) {
            rvAdapter.submitList(it)
            binding.swipeRefresh.isRefreshing = false
        }
        vModel.errorData.observe(viewLifecycleOwner) {
            binding.swipeRefresh.isRefreshing = false
            showLongToast("Something went wrong ¯\\_(ツ)_/¯ => ${it.message}")
        }
    }

    override fun onRefresh() {
        if (!isNetworkAvailable()) {
            binding.swipeRefresh.isRefreshing = false
            showShortToast(getString(R.string.network_connect))
        } else {
            setupRecycle()
        }
    }
}