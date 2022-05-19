package com.vansuita.motivation.data

import android.content.Context

private const val SETTINGS_NAME = "MOTIVATION"

class Settings(context: Context) {

    private var settings = context.getSharedPreferences(SETTINGS_NAME, Context.MODE_PRIVATE)

    object KEYS {
        const val NAME = "NAME"
    }

    fun put(key: String, value: String) {
        settings.edit().putString(key, value).apply()
    }

    fun get(key: String): String = settings.getString(key, "") ?: ""


}