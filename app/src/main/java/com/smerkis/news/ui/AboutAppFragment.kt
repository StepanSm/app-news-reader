package com.smerkis.news.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import by.kirich1409.viewbindingdelegate.viewBinding
import com.smerkis.news.BaseFragment
import com.smerkis.news.R
import com.smerkis.news.databinding.FragmentAboutAppBinding

class AboutAppFragment : BaseFragment(R.layout.fragment_about_app) {

    private val binding: FragmentAboutAppBinding by viewBinding(FragmentAboutAppBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        createToolbar(binding.toolbar)

        binding.newsSource.movementMethod = LinkMovementMethod.getInstance()
        binding.fab.setOnClickListener { sendEmail() }
        binding.libraries.apply {
            jetpack.setOnClickListener { openBrowser("https://developer.android.com/jetpack/getting-started") }
            retrofit.setOnClickListener { openBrowser("https://github.com/square/retrofit") }
            okhttp.setOnClickListener { openBrowser("https://square.github.io/okhttp/") }
            coil.setOnClickListener { openBrowser("https://github.com/coil-kt/coil") }
            recycling.setOnClickListener { openBrowser("https://github.com/utsmannn/Recycling") }
            viewBindingDelegate.setOnClickListener { openBrowser("https://github.com/kirich1409/ViewBindingPropertyDelegate") }
        }
    }

    private fun sendEmail() {
        val emailIntent = Intent(Intent.ACTION_SENDTO)
            .setData(Uri.parse("mailto: stepis@251@gmail.com"))
        startActivity(Intent.createChooser(emailIntent, "Send feedback"))
    }
}