package com.example.travelassistant.trip_generator.trip

import com.example.travelassistant.R

class PresetsList {

    companion object {
        fun getPresets(): ArrayList<Trip> {
            val presets = ArrayList<Trip>()

            val preset1 = Trip("The Taste of Italy",
                1000,
                "Rome\n Milano\n Sicily",
                "Visit hole-in-the-wall pizzerias\n Go on a gorgeous boat ride",
            "Plane: WizzAir",
            "Ristorante Tema",
            R.drawable.italy_org)

            val preset2 = Trip("Shades of London",
            750,
            "London",
                "A tour of the most loved museums of London",
                "Plane: WiizAir",
                "London Brothers\n Archipelago",
            R.drawable.london_org)

            val preset3 = Trip("The Magic of Budapest",
            700,
            "Budapest",
            "Walk down the Danube Promenade\n Visit the Fisherman's Bastion",
            "Train",
            "Fausto's",
            R.drawable.budapest_org)

            presets.add(preset1)
            presets.add(preset2)
            presets.add(preset3)

            return presets
        }
    }
}