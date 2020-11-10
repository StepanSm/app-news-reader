package com.smerkis.news.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentArticleBinding

class ArticleFragment : Fragment(R.layout.fragment_article) {

    private val viewBinding: FragmentArticleBinding by viewBinding(FragmentArticleBinding::bind)
    private val args by navArgs<ArticleFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setContent()
    }

    private fun setContent() {
        viewBinding.apply {
            toolbarImage.load(args.imgURL)
            author.text = args.author
            title.text = args.title
            description.text = args.description
            date.text = args.date
        }
    }


}