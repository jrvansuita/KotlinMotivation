package com.vansuita.motivation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.vansuita.motivation.data.Settings

class UserViewModel(app: Application) : AndroidViewModel(app) {

    private var settings = Settings(app)

    fun saveName(value: String): Boolean {
        settings.put(Settings.KEYS.NAME, value)

        return value != ""
    }

}