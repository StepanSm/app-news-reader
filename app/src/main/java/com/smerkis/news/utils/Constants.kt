package com.smerkis.news.utils

import com.smerkis.news.BuildConfig

class Constants {

    companion object {

        const val API_KEY = BuildConfig.API_KEY

        const val PER_PAGE: Int = 20

        const val NO_DATA: Int = 403

        const val NO_MORE_DATA: Int = 100


        val SOURCE_ARRAY = arrayOf(
            "google-news-in",
            "bbc-news",
            "the-hindu",
            "the-times-of-india",
            "buzzfeed",
            "mashable",
            "mtv-news",
            "bbc-sport",
            "espn-cric-info",
            "talksport",
            "medical-news-today",
            "national-geographic",
            "crypto-coins-news",
            "engadget",
            "the-next-web",
            "the-verge",
            "techcrunch",
            "techradar",
            "ign",
            "polygon"
        )
    }
}