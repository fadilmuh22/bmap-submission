package com.example.bmapsubmission

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var rvCats: RecyclerView

    private val catList: ArrayList<CatBreedData>
        get() {
            val dataNames = resources.getStringArray(R.array.cat_breeds)
            val dataTemperaments = resources.getStringArray(R.array.cat_temperaments)
            val dataDescriptions = resources.getStringArray(R.array.cat_descriptions)
            val dataPhotos = resources.getStringArray(R.array.cat_photos)
            val dataOrigins = resources.getStringArray(R.array.cat_origins)
            val dataVetstreets = resources.getStringArray(R.array.cat_vetstreet_urls)
            val dataCountryFlag = resources.getStringArray(R.array.cat_country_flags)
            val listHero = ArrayList<CatBreedData>()
            for (i in dataNames.indices) {
                val hero =
                    CatBreedData(
                        dataNames[i],
                        dataTemperaments[i],
                        dataDescriptions[i],
                        dataPhotos[i],
                        dataOrigins[i],
                        dataVetstreets[i],
                        dataCountryFlag[i],
                    )
                listHero.add(hero)
            }
            return listHero
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setTitle(R.string.cats_breeds)

        rvCats = findViewById(R.id.rv_cats)
        rvCats.setHasFixedSize(true)

        showRecyclerList()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_about -> {
                val moveIntent = Intent(this@MainActivity, AboutActivity::class.java)
                startActivity(moveIntent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showRecyclerList() {
        rvCats.layoutManager = LinearLayoutManager(this)
        val listHeroAdapter = CatListAdapter(catList)
        rvCats.adapter = listHeroAdapter
    }
}
