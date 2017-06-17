package org.dnltsk.luggagelift.flightinfo

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.springframework.http.HttpStatus.NOT_FOUND

class GatwickFlightInfoHttpControllerTest {

    /**
     * sorry but this is an integration test with the live service.
     * please use sample response data here!!!
     */
    @Test
    fun `an easyjet departure can be found`() {
        val info = GatwickFlightInfoHttpController().loadDepartureFlightInfo("EZY8659")
        assertThat(info.body).isEqualTo(
                FlightInfoResponse(
                        airlineLogoUrl = "http://www.gatwickairport.com/globalassets/airlines/new-airline-logos/easyjet_web_4-1_rgb.png",
                        destinationAirport = "Alicante",
                        departureTime = "05:50",
                        mainStatus = "SCHEDULED",
                        terminal = "North"
                )
        )
    }

    @Test
    fun `wrong stuff returns 404`() {
        val info = GatwickFlightInfoHttpController().loadDepartureFlightInfo("foo-random")
        assertThat(info.statusCode).isEqualTo(NOT_FOUND)
    }
}