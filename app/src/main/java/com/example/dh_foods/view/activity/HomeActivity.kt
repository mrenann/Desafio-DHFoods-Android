package com.example.dh_foods.view.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dh_foods.view.adapter.HomeAdapter
import com.example.dh_foods.R
import com.example.dh_foods.viewModel.RestaurantesViewModel

class HomeActivity : AppCompatActivity() {

    private lateinit var viewModel: RestaurantesViewModel

    private val recyclerView: RecyclerView by lazy {
        findViewById(R.id.rvHomeRestauranteList)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        viewModel = ViewModelProvider(this).get(RestaurantesViewModel::class.java)
        viewModel.getRestaurantes()

        setupRestaurantes()

    }

    private fun setupRestaurantes() {
        viewModel.restaurantesLiveData.observe(this, {
            it?.let{restaurantes ->
                recyclerView.apply {
                    layoutManager = LinearLayoutManager(this@HomeActivity)
                    adapter = HomeAdapter(restaurantes.restaurantesList) {position->
                        val intent = Intent(this@HomeActivity, RestauranteActivity::class.java)
                        intent.putExtra(KEY_INTENT_RESTAURANT,restaurantes.restaurantesList[position])
                        startActivity(intent)
                    }

                }
            }
        })

    }

    companion object {
        const val KEY_INTENT_RESTAURANT = "restaurante"
    }

}