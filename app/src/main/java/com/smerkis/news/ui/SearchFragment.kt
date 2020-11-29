package com.smerkis.news.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import coil.size.Scale
import com.smerkis.news.BaseFragment
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentSearchBinding
import com.smerkis.news.databinding.ItemArticleBinding
import com.smerkis.news.model.Article
import com.smerkis.news.viewmodel.SearchViewModel
import com.utsman.recycling.extentions.Recycling
import com.utsman.recycling.setupAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel


class SearchFragment : BaseFragment(R.layout.fragment_search) {

    private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)
    private val vModel: SearchViewModel by viewModel()
    private var mQuery = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createToolbar(binding.tb, true)
        setupSearchViewListener()
    }


    private fun setupSearchViewListener() {
        binding.searchView.apply {
            queryHint = getString(R.string.search_fragment__hint)

            if (mQuery.isEmpty()) {
                setIconifiedByDefault(false)

                setOnQueryTextFocusChangeListener { v, hasFocus ->
                    if (hasFocus) {
                        v?.findFocus()?.let { showInputMethod(it) }
                    }
                }
            }

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    return true
                }

                override fun onQueryTextChange(query: String?): Boolean {
                    query?.let {
                        if (it.length > 2) {
                            mQuery = query
                            setupRecycle()
                        }
                    }

                    return true
                }
            })
        }
    }


    private fun setupRecycle() {
        binding.rv.setupAdapter<Article>(R.layout.item_article) { adapter, context, mutableList ->

            bind { itemView, position, item ->
                ItemArticleBinding.bind(itemView).apply {
                    tv.text = item?.title
                    img.load(item?.urlToImage) {
                        placeholder(R.drawable.ic_placeholder)
                        error(R.drawable.ic_placeholder)
                        scale(Scale.FILL)
                    }
                    container.setOnClickListener {
                        navigate(
                            SearchFragmentDirections.actionSearchFragmentToArticleFragment(
                                item!!
                            )
                        ) //TODO !!!!!!!
                    }
                }
            }
            val layoutManager = LinearLayoutManager(context)
            setLayoutManager(layoutManager)

            setupData(this, 1)

            onPagingListener(layoutManager) { page, itemCount ->
                setupData(this@setupAdapter, page + 1)
            }
        }
    }

    private fun setupData(recycling: Recycling<Article>, page: Int) {
        vModel.getSearchResult(mQuery, page).observe(viewLifecycleOwner) { newsList ->

            recycling.submitList(newsList)
            binding.tvNoResults.visibility = View.GONE

        }
        vModel.errorData.observe(viewLifecycleOwner) {
            errorHandler(it)
        }

    }

}