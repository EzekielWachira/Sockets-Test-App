package com.ezzy.socketstest.data.repository

import android.content.Context
import android.content.SharedPreferences
import com.ezzy.socketstest.R

class SharedPreferenceManager(context: Context) {

    private val prefs: SharedPreferences = context.getSharedPreferences(
        context.getString(R.string.app_name),
        Context.MODE_PRIVATE
    )

    companion object {
        const val ACCESS_TOKEN = "access_token"
    }

    fun saveAccessToken(token: String) {
        val editor = prefs.edit()
        editor.putString(ACCESS_TOKEN, token)
        editor.apply()
    }

    fun getAccessToken(): String? = prefs.getString(ACCESS_TOKEN, null)

}