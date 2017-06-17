package org.dnltsk.luggagelift.order.confirm

import org.dnltsk.luggagelift.luggage.LuggageRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@RestController
@CrossOrigin(origins = arrayOf("*"))
class OrderConfirmHttpController @Autowired constructor(
        val luggageRepository: LuggageRepository
){

    @RequestMapping("/order/confirm", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun orderConfirm(
            @RequestParam(required = false, defaultValue = "0") orderId: Int,
            @RequestParam(required = false, defaultValue = "2017-06-17T00:00:00Z") pickupTimestamp: Instant,
            @RequestParam(required = false, defaultValue = "2") numberOfBags: Int
    ): OrderConfirmResponse {
        //TODO: validate selected pickUpTimestamp against suggested ones :D
        luggageRepository.reset() // new order => restart!
        return OrderConfirmResponse(
                orderId = orderId,
                pickUpTimestamp = pickupTimestamp,
                bagTrackIds = registerBagTrackIds(numberOfBags)
        )
    }

    internal fun registerBagTrackIds(numberOfBags: Int): List<Int> {
        val bagTrackIds = mutableListOf<Int>()
        for(i in 1..numberOfBags){
            bagTrackIds.add(generateLuggageId())
        }
        return bagTrackIds
    }

    private fun generateLuggageId() : Int {
        val min = 100000
        val max = 999999
        return Random().nextInt(max + 1 - min) + min;
    }


}