package com.example.travelassistant.favorites.favorite

import com.example.travelassistant.R
import com.example.travelassistant.trip_generator.trip.Trip

class FavoritesList {
    companion object {
        private var favorites: ArrayList<Trip> = ArrayList<Trip>()


        fun addFavorite(trip: Trip) {
            favorites.add(trip)
        }

        fun removeFavorite(id: Int) {
            favorites.removeAt(id)
        }

        fun setInitialFavorite() {
            if (favorites.isEmpty()) {
                val favorite1 = Trip("The Taste of Italy",
                    1000,
                    "Rome\n Milano\n Sicily",
                    "Visit hole-in-the-wall pizzerias\n Go on a gorgeous boat ride",
                    "Plane: WizzAir",
                    "Ristorante Tema",
                    R.drawable.italy_org)

                favorites.add(favorite1)
            }
        }

        fun getFavorites(): ArrayList<Trip> {
            return favorites
        }
    }
    
}