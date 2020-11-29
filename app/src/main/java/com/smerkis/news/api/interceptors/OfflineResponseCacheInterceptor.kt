package com.smerkis.news.api.interceptors

import com.smerkis.news.utils.isNetworkAvailable
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class OfflineResponseCacheInterceptor : Interceptor {
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        var request = chain.request()
        if (!isNetworkAvailable()) {

            request = request.newBuilder()
                .removeHeader("Pragma")
                .header("Cache-Control", "public, only-if-cached, max-stale=" + 2419200)
                .build()
        }

        return chain.proceed(request)

    }
}