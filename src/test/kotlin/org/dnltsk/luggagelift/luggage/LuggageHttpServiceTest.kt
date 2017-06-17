package org.dnltsk.luggagelift.luggage

import org.assertj.core.api.Assertions.assertThat
import org.dnltsk.luggagelift.luggage.LuggageStatus.*
import org.dnltsk.luggagelift.order.confirm.OrderConfirmResponse
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.web.client.TestRestTemplate
import org.springframework.test.context.junit4.SpringRunner


@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class LuggageHttpServiceTest {

    @Autowired
    private val restTemplate: TestRestTemplate? = null

    @Before
    fun setUp() {
        val orderConfirmResonse = this.restTemplate!!.getForObject("/order/confirm", OrderConfirmResponse::class.java)
    }

    @Test
    fun `initial status is DRIVER_IN_TRANSIT`() {
        val body = this.restTemplate!!.getForObject("/luggage", LuggageStatusResponse::class.java)
        assertThat(body).isEqualTo(LuggageStatusResponse(luggageStatus = DRIVER_IN_TRANSIT))
    }

    @Test
    fun `status update affects`() {
        val body1 = this.restTemplate!!.postForObject("/luggage?luggageStatus=${BEHIND_SECURITY_CONTROL.name}", null, LuggageStatusResponse::class.java)
        assertThat(body1).isEqualTo(LuggageStatusResponse(luggageStatus = BEHIND_SECURITY_CONTROL))

        val body2 = this.restTemplate!!.postForObject("/luggage?luggageStatus=${ON_PLAN.name}", null, LuggageStatusResponse::class.java)
        assertThat(body2).isEqualTo(LuggageStatusResponse(luggageStatus = ON_PLAN))
    }

    @Test //@Ignore
    fun `new order confirmation rests the luggage status`() {
        //Do some change
        val body1 = this.restTemplate!!.postForObject("/luggage?luggageStatus=${BEHIND_SECURITY_CONTROL.name}", null, LuggageStatusResponse::class.java)
        assertThat(body1).isEqualTo(LuggageStatusResponse(luggageStatus = BEHIND_SECURITY_CONTROL))

        //confirm a new order
        val orderConfirmResonse = this.restTemplate!!.getForObject("/order/confirm", OrderConfirmResponse::class.java)

        //luggage status must be reset
        val body2 = this.restTemplate!!.getForObject("/luggage", LuggageStatusResponse::class.java)
        assertThat(body2).isEqualTo(LuggageStatusResponse(luggageStatus = DRIVER_IN_TRANSIT))
    }


}