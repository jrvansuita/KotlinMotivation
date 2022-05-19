package com.vansuita.motivation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.vansuita.motivation.data.MockPhrases
import com.vansuita.motivation.data.PhraseCategory
import com.vansuita.motivation.data.Settings


class MainViewModel(app: Application) : AndroidViewModel(app) {

    private var userName = MutableLiveData<String>()
    private var phrase = MutableLiveData<String>()

    init {
        userName.value = app.getString(R.string.hi).format(Settings(app).get(Settings.KEYS.NAME))
    }

    fun userName(): LiveData<String> = userName
    fun phrase(): LiveData<String> = phrase

    fun selectMenu(id: Int) {
        val category = PhraseCategory.values().find { it.id == id }
        phrase.value = MockPhrases().get(category).description
    }

}