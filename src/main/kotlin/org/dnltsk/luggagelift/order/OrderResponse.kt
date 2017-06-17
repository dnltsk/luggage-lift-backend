package org.dnltsk.luggagelift.order

import org.dnltsk.luggagelift.model.Costs
import java.time.Instant

data class OrderResponse constructor(
        val orderId: Int,
        val cost: Costs,
        val pickUpTimestamps: List<Instant>
)



