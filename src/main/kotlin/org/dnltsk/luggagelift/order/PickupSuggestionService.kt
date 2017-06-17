package org.dnltsk.luggagelift.order

import org.springframework.stereotype.Service
import java.time.Instant

@Service
class PickupSuggestionService {

    fun suggestPickupTimestamps(pickupAddress: String, flightNumber: String, numberOfBags: Int): List<Instant> {
        return listOf(
                Instant.parse("2017-06-19T08:00:00Z"),
                Instant.parse("2017-06-19T09:30:00Z"),
                Instant.parse("2017-06-19T10:00:00Z")
        )
    }

}