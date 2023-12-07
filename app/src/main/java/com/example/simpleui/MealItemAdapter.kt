package com.example.simpleui

import android.icu.text.Transliterator.Position
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MealItemAdapter(private val contentList:ArrayList<Meal>): RecyclerView.Adapter<MealItemAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
        val imgPhoto:ImageView = itemView.findViewById(R.id.iv_meal)
        val title:TextView = itemView.findViewById(R.id.tv_meals)
        val kalori:TextView = itemView.findViewById(R.id.kalori)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.meal_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val(photo, title, kalori) = contentList[position]
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.imgPhoto)
        holder.title.text = title
        holder.kalori.text = kalori
    }
}