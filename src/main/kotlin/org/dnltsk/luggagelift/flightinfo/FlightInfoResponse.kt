package org.dnltsk.luggagelift.flightinfo

data class FlightInfoResponse constructor(
        val airlineLogoUrl: String,
        val destinationAirport: String,
        val departureTime: String,
        val mainStatus: String,
        val terminal: String
)