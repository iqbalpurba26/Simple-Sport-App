package com.example.simpleui

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class GoalsItemAdapter(private val contentList:ArrayList<String>):RecyclerView.Adapter<GoalsItemAdapter.ViewHolder>() {

    private var selectedPosition: Int = RecyclerView.NO_POSITION


    class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val btnGoals:Button = itemView.findViewById(R.id.btn_goals)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.goals_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return contentList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val position = holder.position
        val data = contentList[position]
        holder.btnGoals.text = data


        // Atur warna latar belakang tombol berdasarkan status klik
        if (position == selectedPosition) {
            holder.btnGoals.setBackgroundResource(R.drawable.button_gain_background) // Warna ketika diklik
            holder.btnGoals.setTextColor(Color.WHITE)
        } else {
            holder.btnGoals.setBackgroundResource(R.drawable.button_goals_background)
            holder.btnGoals.setTextColor(Color.BLACK)
        }

        // Tambahkan listener klik pada tombol
        holder.btnGoals.setOnClickListener {
            // Ubah warna tombol yang sebelumnya diklik ke warna default
            val prevSelectedPosition = selectedPosition
            selectedPosition = position

            // Perbarui tampilan tombol yang sebelumnya diklik
            notifyItemChanged(prevSelectedPosition)

            // Perbarui tampilan tombol yang baru diklik
            notifyItemChanged(selectedPosition)

            // Tambahkan logika lain sesuai kebutuhan
        }

    }

}