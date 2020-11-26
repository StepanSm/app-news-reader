package com.smerkis.news.ui

import android.graphics.Bitmap
import android.os.Bundle
import android.view.MotionEvent
import android.view.View
import android.webkit.*
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.smerkis.news.BaseFragment
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentWebViewBinding

class WebViewFragment : BaseFragment(R.layout.fragment_web_view) {

    private val binding: FragmentWebViewBinding by viewBinding(FragmentWebViewBinding::bind)
    private val args by navArgs<WebViewFragmentArgs>()
    private val webView get() = binding.webView
    private var downX: Float = -1F

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createToolbar()
        if (savedInstanceState == null) {
            binding.webView.loadUrl(args.url)
            initWevView()
        }
    }

    private fun initWevView() {
        webView.webChromeClient = WebChromeClient()
        webView.webViewClient = object : WebViewClient() {

            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                binding.pb.visibility = View.VISIBLE
            }

            override fun shouldOverrideUrlLoading(
                view: WebView?,
                request: WebResourceRequest?
            ): Boolean {
                webView.loadUrl(args.url)
                binding.pb.visibility = View.GONE
                return true
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.pb.visibility = View.GONE
            }
        }

        webView.apply {
            clearCache(true)
            clearHistory()
            settings.javaScriptEnabled = true
            isHorizontalScrollBarEnabled = false

        }
        webView.setOnTouchListener { v, event ->
            if (event.pointerCount > 1) {
                return@setOnTouchListener true
            }

            when (event.action) {
                MotionEvent.ACTION_DOWN -> downX = event.getX()
                MotionEvent.ACTION_MOVE,
                MotionEvent.ACTION_CANCEL,
                MotionEvent.ACTION_UP -> event.setLocation(downX, event.getY())
            }
            return@setOnTouchListener false
        }
    }


    private fun createToolbar() {
        activity.setSupportActionBar(binding.toolbar)
        activity.actionBar?.setDisplayHomeAsUpEnabled(true)
        binding.toolbar.apply {
            setNavigationIcon(R.drawable.ic_back_btn)
            title = args.url
            setNavigationOnClickListener {
                popBackStack()
            }
        }
    }

}