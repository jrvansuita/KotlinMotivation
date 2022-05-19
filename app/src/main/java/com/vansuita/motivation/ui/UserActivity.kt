package com.vansuita.motivation.ui

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.vansuita.motivation.R
import com.vansuita.motivation.UserViewModel
import com.vansuita.motivation.data.Settings
import com.vansuita.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityUserBinding
    private lateinit var viewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = ViewModelProvider(this).get(UserViewModel::class.java)
        binding.buttonSave.setOnClickListener(this)
        supportActionBar?.hide()

        if (Settings(this).get(Settings.KEYS.NAME) != "") goMain()
    }


    override fun onClick(v: View) {
        if (v.id == R.id.button_save) {
            if (viewModel.saveName(binding.editName.text.toString())) {
                goMain()
            } else {
                Toast.makeText(this, R.string.what_s_your_name, Toast.LENGTH_SHORT).show()
            }
        }
    }

    fun goMain() {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }


}