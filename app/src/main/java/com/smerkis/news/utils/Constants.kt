package com.smerkis.news.utils

import com.smerkis.news.BuildConfig

class Constants {

    companion object {

        const val API_KEY = BuildConfig.API_KEY

        val CATEGORIES = arrayListOf(
            "General",
            "Entertainment",
            "Sports",
            "Business",
            "Technology",
            "Science",
            "Health"
        )

    }
}