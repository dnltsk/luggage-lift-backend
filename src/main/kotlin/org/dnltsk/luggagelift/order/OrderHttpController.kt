package org.dnltsk.luggagelift.order

import org.dnltsk.luggagelift.model.Costs
import org.dnltsk.luggagelift.model.Currency.EUR
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.Instant
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
            @RequestParam seatNumber: String,
            @RequestParam pickupAddress: String,
            @RequestParam numberOfBags: Int
    ): OrderResponse {

        return OrderResponse(
                orderId = generateOrderId(),
                cost = costsService.calculateCosts(numberOfBags),
                pickUpTimestamps = pickupSuggestionService.suggestPickupTimestamps(pickupAddress, flightNumber, numberOfBags)
        )
    }

    @RequestMapping("/order/submit", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun order(
            @RequestParam orderId : Int,
            @RequestParam pickupTimestamp: Instant
    ): OrderResponse{
        //TODO: load metadata from db
        //TODO: validate selected pickUpTimestamp against suggested ones
        return OrderResponse(
                orderId = orderId,
                cost = Costs(value = 5.0, currency = EUR),
                pickUpTimestamps = listOf(pickupTimestamp)
        )
    }

    internal fun generateOrderId() : Int {
        val min = 0
        val max = 100
        return Random().nextInt(max + 1 - min) + min;
    }


}