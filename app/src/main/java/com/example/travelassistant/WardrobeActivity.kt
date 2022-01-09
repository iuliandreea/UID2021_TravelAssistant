package com.example.travelassistant

import android.os.Bundle
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class WardrobeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        var listView: ListView
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wardrobe)

        val recyclerView: RecyclerView = findViewById(R.id.weather_recycler)
        val recyclerAdapter: WeatherRecyclerAdapter = WeatherRecyclerAdapter(this)
        recyclerView.adapter = recyclerAdapter
        val listOfItems: List<Weather> =
            listOf(Weather(1, 23, "23%", "78%", "34%"),
                   Weather(2, 26, "29%", "75%", "23%"),
                   Weather(3, 24, "30%", "73%", "31%"),
                   Weather(4, 27, "14%", "68%", "37%")
                )
        recyclerAdapter.setWeatherListItems(listOfItems)
        recyclerView.layoutManager = LinearLayoutManager(this);

    }
}