package com.smerkis.news.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.smerkis.news.MainActivity
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentSearchBinding
import com.smerkis.news.model.ArticleStructure
import com.smerkis.news.viewmodel.SearchViewModel
import com.utsman.recycling.setupAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class SearchFragment : Fragment(R.layout.fragment_search) {

    private val binding: FragmentSearchBinding by viewBinding(FragmentSearchBinding::bind)
    private val vModel: SearchViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createToolbar()
        setHasOptionsMenu(true)

        binding.rv.setupAdapter<ArticleStructure>(R.layout.item_article) { adapter, context, mutableList ->

            bind { itemView, position, item ->  }

        }


    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        (activity as MainActivity).menuInflater.inflate(R.menu.menu_search, menu)
    }

    
    private fun createToolbar() {
        (activity as MainActivity).setSupportActionBar(binding.toolbar)
        (activity as MainActivity).actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_back_btn)
            title = ""
            setNavigationOnClickListener {
                findNavController().popBackStack()
            }
        }
    }

}