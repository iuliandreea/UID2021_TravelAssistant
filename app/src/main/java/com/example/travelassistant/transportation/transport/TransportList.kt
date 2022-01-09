package com.example.travelassistant.transportation.transport

class TransportList {

    companion object {
        fun getTransport(): ArrayList<Transport> {
            val transport = ArrayList<Transport>()

            val transport1 = Transport("Paris",
                "Cluj-Napoca",
                "N/A",
                "car",
                250,
            "",
            "12:00",
            "18:00")

            val transport2 = Transport("Paris",
                "Cluj-Napoca",
                "WizzAir",
                "plane",
                100,
                "",
            "13:00",
            "19:00")

            val transport5 = Transport("Paris",
                "Cluj-Napoca",
                "BlueAir",
                "plane",
                150,
                "",
            "11:00",
            "23:00")

            val transport3 = Transport("Paris",
                "Cluj-Napoca",
                "Some Train Company",
                "train",
                300,
                "",
            "15:00",
                "20:00")

            val transport4 = Transport("Paris",
                "Cluj-Napoca",
                "FlixBus",
                "bus",
                300,
                "",
            "11:00",
            "19:00")

            transport.add(transport1)
            transport.add(transport2)
            transport.add(transport3)
            transport.add(transport4)
            transport.add(transport5)

            return transport
        }
    }
}