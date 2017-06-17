package org.dnltsk.luggagelift.order.submit

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.time.Instant
import java.util.*

@RestController
class OrderSubmitHttpController {

    @RequestMapping("/order/submit", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun orderSubmit(
            @RequestParam orderId: Int,
            @RequestParam pickupTimestamp: Instant,
            @RequestParam numberOfBags: Int
    ): OrderSubmitResponse {
        //TODO: load metadata from db
        //TODO: validate selected pickUpTimestamp against suggested ones
        return OrderSubmitResponse(
                orderId = orderId,
                pickUpTimestamp = pickupTimestamp,
                luggageIds = registerLuggageIds(numberOfBags)
        )
    }

    internal fun registerLuggageIds(numberOfBags: Int): List<Int> {
        val luggageIds = mutableListOf<Int>()
        for(i in 1..numberOfBags){
            luggageIds.add(generateLuggageId())
        }
        return luggageIds
    }

    internal fun generateLuggageId() : Int {
        val min = 100000
        val max = 999999
        return Random().nextInt(max + 1 - min) + min;
    }


}