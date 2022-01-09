package com.example.travelassistant.trip_generator.trip

import com.example.travelassistant.models.activity.Activity
import com.example.travelassistant.models.restaurant.Restaurant
import com.example.travelassistant.transportation.transport.Transport
import com.example.travelassistant.models.location.Location

class Trip (public var name: String = "",
            public var price: Int = 0,
            public var locations: String,
            public var activities: String,
            public var transport: String,
            public var restaurants: String,
            public var image: Int,) {

}