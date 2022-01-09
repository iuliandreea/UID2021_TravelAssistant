package com.example.travelassistant.food

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travelassistant.R

class RestaurantRecyclerViewAdapter : RecyclerView.Adapter<RestaurantRecyclerViewAdapter.ViewHolder>(){
    private var restaurants: List<RestaurantViewModel> = emptyList()

    fun loadRestaurants(){
        val restaurantsListLoader = RestaurantsList()
        this.restaurants = restaurantsListLoader.loadRestaurantsList()
    }

    // create new views
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        // inflates the card_view_design view
        // that is used to hold list item
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.card_layout, parent, false)
        return ViewHolder(view)
    }

    // binds the list items to a view
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val restaurantViewModel = restaurants[position]

        // sets the text to the textview from our itemHolder class
        holder.nameView.text = restaurantViewModel.name
        holder.imageView.setImageResource(restaurantViewModel.imageId)
    }

    // return the number of the items in the list
    override fun getItemCount(): Int {
        return restaurants.size
    }

    // Holds the views for adding it to image and text
    inner class ViewHolder(RestaurantView: View) : RecyclerView.ViewHolder(RestaurantView) {
        var nameView: TextView = RestaurantView.findViewById(R.id.restaurantName)
        var imageView: ImageView = RestaurantView.findViewById(R.id.restaurantImageView)
    }
}