package com.example.dh_foods.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.dh_foods.R
import com.example.dh_foods.models.Prato

class PratoRestauranteAdapter(
        private val pratoList: List<Prato>,
        private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<PratoRestauranteAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.pratos_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(pratoList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return pratoList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(prato: Prato, onItemClicked: (Int) -> Unit) = with(itemView) {

            Glide.with(itemView.context)
                    .load(prato.image)
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(findViewById(R.id.ivPhotoPrato))

            findViewById<TextView>(R.id.tvPratoName).text = prato.nome

            findViewById<ViewGroup>(R.id.vgPratoItemContainer).setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }

    }
}