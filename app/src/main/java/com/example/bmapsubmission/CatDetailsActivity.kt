package com.example.bmapsubmission

import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.bmapsubmission.databinding.ActivityCatDetailsBinding

class CatDetailsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCatDetailsBinding

    companion object {
        const val EXTRA_CAT = "extra_cat"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCatDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setTitle(R.string.cats_breeds_details)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val catBreedData =
            if (Build.VERSION.SDK_INT >= 33) {
                intent.getParcelableExtra<CatBreedData>(EXTRA_CAT, CatBreedData::class.java)
            } else {
                @Suppress("DEPRECATION")
                intent.getParcelableExtra<CatBreedData>(EXTRA_CAT)
            }

        if (catBreedData != null) {
            title = "${catBreedData.name} details"
            binding.catDetailsName.text = catBreedData.name
            binding.catDetailsTemperaments.text = catBreedData.temperaments
            binding.catDetailsDescription.text = catBreedData.description

            binding.catDetailsOrigin.text = "Origin: ${catBreedData.origin} ${catBreedData.countryFlag}"

            Glide.with(this)
                .load(catBreedData.photo)
                .into(binding.catDetailsPhoto)

            binding.actionShare.setOnClickListener {
                val share =
                    Intent.createChooser(
                        Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, catBreedData.vetStreet)
                            putExtra(Intent.EXTRA_TITLE, "Checkout this cat breed")
                            type = "text/plain"
                        },
                        null,
                    )
                startActivity(share)
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
