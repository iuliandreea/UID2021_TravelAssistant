package com.example.travelassistant.models.location

class LocationsList {

    companion object {
        fun getLocations(): ArrayList<Location> {
            val locations = ArrayList<Location>()

            val location1 = Location("Rome", "Italy", "Europe")
            val location2 = Location("Paris", "France", "Europe")
            val location3 = Location("London", "United Kingdom", "Europe")
            val location4 = Location("Milano", "Italy", "Europe")
            val location5 = Location("Cluj-Napoca", "Romania", "Europe")
            val location6 = Location("Bucharest", "Romania", "Europe")

            val location7 = Location("Tokyo", "Japan", "Asia")
            val location8 = Location("Kyoto", "Japan", "Asia")
            val location9 = Location("Beijing", "China", "Asia")
            val location10 = Location("Singapore", "Singapore", "Asia")
            val location11 = Location("Mumbai", "India", "Asia")

            val location12 = Location("New York", "USA", "North America")
            val location13 = Location("Los Angeles", "USA", "North America")
            val location14 = Location("Toronto", "Canada", "North America")
            val location15 = Location("Vancouver", "Canada", "North America")

            val location16 = Location("Sao Paolo", "Brazil", "South America")
            val location17 = Location("Lima", "Peru", "South America")
            val location18 = Location("Bogota", "Colombia", "South America")

            val location19 = Location("Cape Town", "South Africa", "Africa")
            val location20 = Location("Cairo", "Egypt", "Africa")

            locations.add(location1)
            locations.add(location2)
            locations.add(location3)
            locations.add(location4)
            locations.add(location5)
            locations.add(location6)
            locations.add(location7)
            locations.add(location8)
            locations.add(location9)
            locations.add(location10)
            locations.add(location11)
            locations.add(location12)
            locations.add(location13)
            locations.add(location14)
            locations.add(location15)
            locations.add(location16)
            locations.add(location17)
            locations.add(location18)
            locations.add(location19)
            locations.add(location20)

            return locations
        }
    }
}