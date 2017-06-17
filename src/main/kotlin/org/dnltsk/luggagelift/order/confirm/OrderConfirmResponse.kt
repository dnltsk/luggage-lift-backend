package org.dnltsk.luggagelift.order.confirm

import java.time.Instant

data class OrderConfirmResponse constructor(
        val orderId: Int,
        val pickUpTimestamp: Instant,
        val bagTrackIds: List<Int>
){
}