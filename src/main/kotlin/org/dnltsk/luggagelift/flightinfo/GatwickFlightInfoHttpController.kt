package org.dnltsk.luggagelift.flightinfo

import org.jsoup.Jsoup
import org.springframework.http.HttpStatus.NOT_FOUND
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RestController

@RestController
@CrossOrigin(origins = arrayOf("*"))
class GatwickFlightInfoHttpController {

    /**
     * flightId example: EZY8659
     */
    @RequestMapping("/flightinfo", method = arrayOf(RequestMethod.GET), produces = arrayOf(MediaType.APPLICATION_JSON_UTF8_VALUE))
    fun loadDepartureFlightInfo(
            flightId: String
    ): ResponseEntity<FlightInfoResponse> {
        val url = "http://www.gatwickairport.com/flights/departures-results/?flight=$flightId"
        val doc = Jsoup.connect(url).get()
        val flightInfoRow = doc.select(".flight-info-row")
        if (flightInfoRow.size == 0) {
            return ResponseEntity(NOT_FOUND)
        }


        return ResponseEntity.ok(FlightInfoResponse(
                airlineLogoUrl = "http://www.gatwickairport.com" + flightInfoRow.select("td img").attr("src"),
                departureTime = flightInfoRow.select("td").get(1).text(),
                destinationAirport = flightInfoRow.select("td").get(2).text(),
                mainStatus = flightInfoRow.select(".mainStatus").text(),
                terminal = flightInfoRow.select("td").get(5).text()
        ))

    }

}