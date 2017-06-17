package org.dnltsk.luggagelift.luggage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*


@RestController
@CrossOrigin(origins = arrayOf("*"))
class LuggageHttpService @Autowired constructor(
        val luggageStatusService: LuggageStatusService
){

    @RequestMapping("/luggage", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun getStatus(
            @RequestParam(required = false, defaultValue = "0") orderId: Int
    ): LuggageStatusResponse {
        //TODO: verify orderId
        return LuggageStatusResponse(
                luggageStatus = luggageStatusService.loadLuggageStatus(orderId)
        )
    }

    @RequestMapping("/luggage", method = arrayOf(RequestMethod.POST), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun updateStatus(
            @RequestParam(required = false, defaultValue = "0") orderId: Int,
            @RequestParam luggageStatus: LuggageStatus
    ): LuggageStatusResponse {
        //TODO: verify orderId
        return LuggageStatusResponse(
                luggageStatus = luggageStatusService.updateLuggageStatus(orderId, luggageStatus)
        )
    }

}