package com.example.travelassistant.attraction

import androidx.annotation.DrawableRes

data class Attraction(
    var id: String,
    var name: String,
    var address: String,
    var price: String,
    var description: String,
    var contact: String,
    @DrawableRes
    var image: Int
) {
}