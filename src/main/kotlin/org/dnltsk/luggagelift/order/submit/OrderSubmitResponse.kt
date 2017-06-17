package org.dnltsk.luggagelift.order.submit

import java.time.Instant

data class OrderSubmitResponse constructor(
        val orderId: Int,
        val pickUpTimestamp: Instant,
        val luggageIds: List<Int>
){
}