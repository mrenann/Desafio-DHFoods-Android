package com.example.dh_foods.view.activity

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.TextView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.dh_foods.R
import com.example.dh_foods.models.Prato
import kotlinx.android.synthetic.main.activity_prato_restaurante.*

class PratoRestauranteActivity : AppCompatActivity() {
    private var prato: Prato? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_prato_restaurante)

        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        window.statusBarColor = Color.TRANSPARENT

        prato = intent.getParcelableExtra(RestauranteActivity.KEY_INTENT_PRATO)

        setupPrato()

        backButtonPrato.setOnClickListener {
            finish()
        }
    }

    private fun setupPrato() {
        Glide.with(this)
            .load(prato?.image)
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .into(findViewById(R.id.ivPratoActivityPhoto))

        findViewById<TextView>(R.id.tvPratoActivityName).text = prato?.nome
        findViewById<TextView>(R.id.tvPratoActivityDescricao).text = prato?.descricao
    }
}