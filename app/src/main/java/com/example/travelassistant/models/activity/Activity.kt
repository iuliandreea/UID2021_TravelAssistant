package com.example.travelassistant.models.activity

import com.example.travelassistant.models.location.Location

class Activity (public var name: String,
                public var location: Location,
                public var price: Int,
                public var type: String) {
}