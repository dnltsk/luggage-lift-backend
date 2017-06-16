package org.dnltsk.luggagelift.order

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import java.time.Instant
import java.util.*

@RestController
@CrossOrigin(origins = arrayOf("*"))
class OrderHttpController @Autowired constructor(
        val costsService: CostsService
){

    @RequestMapping("/order", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun order(
            @RequestParam flightId: String,
            @RequestParam flightDate: Instant,
            @RequestParam numberOfBags: Int
    ): OrderResponse {

        return OrderResponse(
                orderId = generateOrderId(),
                cost = costsService.calculateCosts(numberOfBags)
        )
    }

    internal fun generateOrderId() : Int {
        val min = 0
        val max = 100
        return Random().nextInt(max + 1 - min) + min;
    }


}