package com.smerkis.news.ui

import android.annotation.SuppressLint
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
    private var downX: Float = -1F

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        createToolbar(binding.tb, true, args.url)
        initWevView()
    }

    @SuppressLint("ClickableViewAccessibility", "SetJavaScriptEnabled")
    private fun initWevView() {
        binding.webView.apply {
            webChromeClient = WebChromeClient()
            webViewClient = WebViewClient()
            CookieManager.getInstance().setAcceptCookie(true)
            settings.databaseEnabled = true
            clearCache(true)
            settings.domStorageEnabled = true
            clearHistory()
            settings.javaScriptEnabled = true
            isHorizontalScrollBarEnabled = false


            setOnTouchListener { v, event ->
                if (event.pointerCount > 1) {
                    return@setOnTouchListener true
                }

                when (event.action) {
                    MotionEvent.ACTION_DOWN -> downX = event.x
                    MotionEvent.ACTION_MOVE,
                    MotionEvent.ACTION_CANCEL,
                    MotionEvent.ACTION_UP -> {
                        event.setLocation(downX, event.y)
                        v.performClick()
                    }
                }
                return@setOnTouchListener false
            }
            loadUrl(args.url)
        }
    }
}