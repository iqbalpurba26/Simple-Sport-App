package com.example.simpleui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class AddExerciseAdapter(private val contentList:ArrayList<AddExercise>): RecyclerView.Adapter<AddExerciseAdapter.ViewHolder>() {
    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val bgPhoto:ImageView = itemView.findViewById(R.id.bg_iv)
        val photo:ImageView = itemView.findViewById(R.id.iv_addExercise)
        val title:TextView = itemView.findViewById(R.id.tv_title)
        val tvKalori:TextView = itemView.findViewById(R.id.tv_kalori)
        val time : TextView = itemView.findViewById(R.id.time_addExercise)
        val level : TextView = itemView.findViewById(R.id.level_addExercise)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.add_exercise_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (bgPhoto, photo, title, kalori, time, level) = contentList[position]
        Glide.with(holder.itemView.context)
            .load(bgPhoto)
            .into(holder.bgPhoto)
        Glide.with(holder.itemView.context)
            .load(photo)
            .into(holder.photo)
        holder.tvKalori.text = kalori
        holder.title.text = title
        holder.time.text = time
        holder.level.text = level
    }
}