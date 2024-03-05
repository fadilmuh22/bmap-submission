package com.example.bmapsubmission

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.bmapsubmission.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        binding.aboutName.text = resources.getString(R.string.about_name)
        binding.aboutEmail.text = resources.getString(R.string.about_email)

        Glide.with(this)
            .load(resources.getString(R.string.about_photo))
            .into(binding.aboutProfileImage)
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
