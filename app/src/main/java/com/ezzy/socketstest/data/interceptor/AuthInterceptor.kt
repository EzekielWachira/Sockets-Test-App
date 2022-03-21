package com.ezzy.socketstest.data.interceptor

import android.content.Context
import com.ezzy.socketstest.data.repository.SharedPreferenceManager
import okhttp3.Interceptor
import okhttp3.Response

class AuthInterceptor(context: Context): Interceptor {
    private val preferencesManager = SharedPreferenceManager(context)

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()

        preferencesManager.getAccessToken()?.let {
            requestBuilder.apply {
                addHeader("Authorization", "Bearer $it")
            }
        }

        return chain.proceed(requestBuilder.build())
    }
}