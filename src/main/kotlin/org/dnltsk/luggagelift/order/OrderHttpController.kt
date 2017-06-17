package org.dnltsk.luggagelift.order

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@CrossOrigin(origins = arrayOf("*"))
class OrderHttpController @Autowired constructor(
        val costsService: CostsService,
        val pickupSuggestionService: PickupSuggestionService
){

    @RequestMapping("/order", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun order(
            @RequestParam flightNumber: String,
            @RequestParam(required = false, defaultValue = "12A") seatNumber: String,
            @RequestParam(required = false, defaultValue = "Winterfeldtstraße 21, 10781 Berlin") pickupAddress: String,
            @RequestParam numberOfBags: Int
    ): OrderResponse {

        return OrderResponse(
                orderId = generateOrderId(),
                cost = costsService.calculateCosts(numberOfBags),
                pickUpTimestamps = pickupSuggestionService.suggestPickupTimestamps(pickupAddress, flightNumber, numberOfBags)
        )
    }

    internal fun generateOrderId() : Int {
        val min = 100000
        val max = 999999
        return Random().nextInt(max + 1 - min) + min;
    }


}