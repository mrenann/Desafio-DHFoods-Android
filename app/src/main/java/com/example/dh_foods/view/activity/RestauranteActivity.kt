package com.example.dh_foods.view.activity

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.dh_foods.R
import com.example.dh_foods.models.Restaurante
import com.example.dh_foods.view.activity.HomeActivity.Companion.KEY_INTENT_RESTAURANT
import com.example.dh_foods.view.adapter.PratoRestauranteAdapter
import kotlinx.android.synthetic.main.activity_restaurante.*

class RestauranteActivity : AppCompatActivity() {
    private var restaurante: Restaurante? = null

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rvPratoRestauranteList)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_restaurante)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.statusBarColor = Color.TRANSPARENT
        restaurante = intent.getParcelableExtra(KEY_INTENT_RESTAURANT)

        setupRestaurante()

        backButtonRestaurante.setOnClickListener {
            finish()
        }

    }

    private fun setupRestaurante() {
        Glide.with(this)
                .load(restaurante?.image)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(findViewById(R.id.ivRestauranteActivityPhoto))
        findViewById<TextView>(R.id.tvRestauranteActivityName).text = restaurante?.nome

        restaurante?.pratoPrincipais?.let{ pratos->
            if(pratos.isNotEmpty()) {
                findViewById<TextView>(R.id.tvNaoPossuiPratos).visibility = View.GONE
                recyclerView.apply {
                    layoutManager = GridLayoutManager(this@RestauranteActivity, 2)
                    adapter = PratoRestauranteAdapter(pratos) { position ->
                        val intent = Intent(this@RestauranteActivity, PratoRestauranteActivity::class.java)
                        intent.putExtra(KEY_INTENT_PRATO, pratos[position])
                        startActivity(intent)
                    }
                }
            }else{
                findViewById<TextView>(R.id.tvNaoPossuiPratos).visibility = View.VISIBLE
            }
    }

    }

    companion object {
        const val KEY_INTENT_PRATO = "prato"
    }
}