package com.vansuita.motivation.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.vansuita.motivation.MainViewModel
import com.vansuita.motivation.R
import com.vansuita.motivation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel
    private var lastSelectedMenu = R.id.image_all

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        setListeners()
        setObservers()

        selectMenu(lastSelectedMenu)
    }

    override fun onClick(view: View) {
        if (view.id == R.id.button_new_phrase) {
            selectMenu(lastSelectedMenu)
        } else if (view.id in listOf(R.id.image_all, R.id.image_happy, R.id.image_sunny)) {
            lastSelectedMenu = view.id
            selectMenu(view.id)
        }
    }

    private fun selectMenu(id: Int) {
        val images = listOf(binding.imageAll, binding.imageSunny, binding.imageHappy)
        val colorWhite = ContextCompat.getColor(this, R.color.white)

        images.forEach { it.colorFilter = null }

        images.find { it.id == id }?.setColorFilter(colorWhite)

        viewModel.selectMenu(id)
    }

    private fun setListeners() {
        binding.buttonNewPhrase.setOnClickListener(this)
        binding.imageAll.setOnClickListener(this)
        binding.imageHappy.setOnClickListener(this)
        binding.imageSunny.setOnClickListener(this)
    }

    private fun setObservers() {
        viewModel.userName().observe(this, Observer {
            binding.textGreeting.text = it
        })

        viewModel.phrase().observe(this, Observer {
            binding.textPhrase.text = it
        })
    }

}