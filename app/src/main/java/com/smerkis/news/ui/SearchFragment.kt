package com.smerkis.news.ui

import android.content.Context.INPUT_METHOD_SERVICE
import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import android.view.inputmethod.EditorInfo
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
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

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createToolbar()
        setHasOptionsMenu(true)
        setupRecycling()

        binding.etSearch.setOnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val mrg =
                    activity.getSystemService(INPUT_METHOD_SERVICE) as InputMethodManager
                mrg.hideSoftInputFromWindow(v?.windowToken, 0)
                vModel.getSearchResult(binding.etSearch.text.toString().trim())
            }
            false
        }
    }

    private fun setupRecycling() {
        binding.rv.setupAdapter<Article>(R.layout.item_article) { adapter, context, mutableList ->

            bind { itemView, position, item ->
                ItemArticleBinding.bind(itemView).apply {
                    tv.text = item?.title
                    img.load(item?.urlToImage){
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
        vModel.searchListResult.observe(viewLifecycleOwner) {
            recycling.submitList(it)
        }
        vModel.errorData.observe(viewLifecycleOwner) {
            Toast.makeText(context, "${it.message}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        activity.menuInflater.inflate(R.menu.menu_search, menu)
    }

    private fun createToolbar() {
        activity.setSupportActionBar(binding.toolbar)
        activity.actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_back_btn)
            title = ""
            setNavigationOnClickListener {
                popBackStack()
            }
        }
    }
}