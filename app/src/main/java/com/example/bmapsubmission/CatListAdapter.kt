package com.example.bmapsubmission

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class CatListAdapter(private val catList: List<CatBreedData>) : RecyclerView.Adapter<CatListAdapter.CatViewHolder>() {
    inner class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val catPhoto: ImageView = itemView.findViewById(R.id.catPhoto)
        val catName: TextView = itemView.findViewById(R.id.catName)
        val catTemperaments: TextView = itemView.findViewById(R.id.catTemperaments)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int,
    ): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun onBindViewHolder(
        holder: CatViewHolder,
        position: Int,
    ) {
        val currentCat = catList[position]

        holder.catName.text = currentCat.name
        holder.catTemperaments.text = "Temperaments: ${currentCat.temperaments}"

        Glide.with(holder.itemView.context)
            .load(currentCat.photo)
            .into(holder.catPhoto)

        holder.itemView.setOnClickListener {
            val moveIntent =
                Intent(holder.itemView.context, CatDetailsActivity::class.java).run {
                    putExtra(CatDetailsActivity.EXTRA_CAT, currentCat)
                }
            holder.itemView.context.startActivity(moveIntent)
        }
    }

    override fun getItemCount(): Int {
        return catList.size
    }
}
