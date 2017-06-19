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
        val info = GatwickFlightInfoHttpController().loadDepartureFlightInfo("DY7045")
        assertThat(info.body).isEqualTo(
                FlightInfoResponse(
                        airlineLogoUrl="http://www.gatwickairport.com/globalassets/airlines/new-airline-logos/norwegian_web_4-1_rgb.png",
                        destinationAirport="Fort Lauderdale",
                        departureTime="15:40",
                        mainStatus="SCHEDULED",
                        terminal="South"
                )
        )
    }

    @Test
    fun `wrong stuff returns 404`() {
        val info = GatwickFlightInfoHttpController().loadDepartureFlightInfo("foo-random")
        assertThat(info.statusCode).isEqualTo(NOT_FOUND)
    }
}