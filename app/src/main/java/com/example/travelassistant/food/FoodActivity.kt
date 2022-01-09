package com.example.travelassistant.food

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R


class FoodActivity : AppCompatActivity() {
    private lateinit var recyclerView: RecyclerView
    private lateinit var restaurantRecyclerViewAdapter: RestaurantRecyclerViewAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food)

        // getting the recyclerview by its id
        recyclerView = findViewById(R.id.restaurantRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this@FoodActivity, RecyclerView.VERTICAL, false)
        restaurantRecyclerViewAdapter = RestaurantRecyclerViewAdapter()
        restaurantRecyclerViewAdapter.loadRestaurants()
        recyclerView.adapter = restaurantRecyclerViewAdapter
        recyclerView.adapter

    }
}