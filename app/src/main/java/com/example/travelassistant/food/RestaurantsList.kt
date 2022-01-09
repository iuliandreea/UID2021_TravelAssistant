package com.example.travelassistant.food

import com.example.travelassistant.R

class RestaurantsList() {
    fun loadRestaurantsList(): List<RestaurantViewModel> {
        return listOf<RestaurantViewModel>(
            RestaurantViewModel("Oriental Dragon", R.drawable.restaurant1),
            RestaurantViewModel("Mi Casa", R.drawable.restaurant2),
            RestaurantViewModel("Bella Italia", R.drawable.restaurant3),
            RestaurantViewModel("Marty", R.drawable.restaurant4),
        )
    }
}