package com.example.dh_foods.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.dh_foods.R
import com.example.dh_foods.models.Restaurante


class HomeAdapter(
    private val restaurantList: List<Restaurante>,
    private val onItemClicked: (Int) -> Unit
) : RecyclerView.Adapter<HomeAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.restaurante_list_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(restaurantList[position], onItemClicked)
    }

    override fun getItemCount(): Int {
        return restaurantList.size
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(restaurante: Restaurante, onItemClicked: (Int) -> Unit) = with(itemView) {

            Glide.with(itemView.context)
                .load(restaurante.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(findViewById(R.id.ivPhotoRestaurant))

            findViewById<TextView>(R.id.tvRestauranteName).text = restaurante.nome
            findViewById<TextView>(R.id.tvRestauranteLocation).text = restaurante.localizacao
            findViewById<TextView>(R.id.tvRestauranteFechamento).text = context.getString(R.string.quandoFecha, restaurante.fechamento)

            findViewById<ViewGroup>(R.id.vgRestauranteItemContainer).setOnClickListener {
                onItemClicked(this@ViewHolder.adapterPosition)
            }
        }

    }
}