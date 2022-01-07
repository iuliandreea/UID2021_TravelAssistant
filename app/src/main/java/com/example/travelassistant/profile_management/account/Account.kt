package com.example.travelassistant.profile_management.account

class Account (public var email: String,
               public var password: String,
               public var fullName: String,
               public var favorites: ArrayList<Int> = ArrayList<Int>(),
               public var accTrips: ArrayList<Int> = ArrayList<Int>()) {
}