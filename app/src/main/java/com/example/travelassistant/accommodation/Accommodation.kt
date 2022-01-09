package com.example.travelassistant.accommodation

import androidx.annotation.DrawableRes

data class Accommodation(
    var id: String,
    var name: String,
    var address: String,
    var price: String,
    var contact: String,
    @DrawableRes
    var image: Int,
) {
}