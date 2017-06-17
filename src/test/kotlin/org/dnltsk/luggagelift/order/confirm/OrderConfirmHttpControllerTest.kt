package org.dnltsk.luggagelift.order.confirm

import org.dnltsk.luggagelift.luggage.LuggageRepository
import org.junit.Assert.assertEquals
import org.junit.Test

class OrderConfirmHttpControllerTest {

    @Test
    fun `correct number of luggageIds are generated`() {
        val controller = OrderConfirmHttpController(LuggageRepository())
        val fiveBags = 5
        val fiveLuggageIds = controller.registerBagTrackIds(fiveBags)
        assertEquals(fiveLuggageIds.size, fiveBags)
    }
}