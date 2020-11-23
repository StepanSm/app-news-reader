package com.smerkis.news.utils

import com.smerkis.news.BuildConfig
import java.util.*

class Constants {

    companion object {

        const val API_KEY = BuildConfig.API_KEY

        const val PER_PAGE: Int = 20

        const val NO_DATA: Int = 403

        const val NO_MORE_DATA: Int = 100


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