package com.smerkis.news.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.smerkis.news.BaseFragment
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentArticleBinding

class ArticleFragment : BaseFragment(R.layout.fragment_article) {

    private val binding: FragmentArticleBinding by viewBinding(FragmentArticleBinding::bind)
    private val args by navArgs<ArticleFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createToolbar(binding.tb, true)

        binding.apply {
            image.load(args.article.urlToImage)
            source.text = args.article.source.name
            title.text = args.article.title
            date.text = args.article.publishedAt
            description.text = args.article.description
            content.text = args.article.content
            goWebView.setOnClickListener {
                navigate(
                    ArticleFragmentDirections.actionArticleFragmentToWebViewFragment(
                        args.article.url
                    )
                )
            }
            fab.setOnClickListener {
                sendArticle()
            }

        }
    }

    private fun sendArticle() {
        val shareIntent = Intent()
        shareIntent.action = Intent.ACTION_SEND
        shareIntent.type = "text/plain"
        shareIntent.putExtra(
            Intent.EXTRA_TEXT,
            "Check out this news! Send from MyTimes App\n${Uri.parse(args.article.url)}"
        )
        startActivity(Intent.createChooser(shareIntent, "Share with"))
    }
}