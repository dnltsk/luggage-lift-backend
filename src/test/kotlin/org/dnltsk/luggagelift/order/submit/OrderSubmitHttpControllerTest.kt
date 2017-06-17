package org.dnltsk.luggagelift.order.submit

import org.junit.Assert.assertEquals
import org.junit.Test

class OrderSubmitHttpControllerTest{

    @Test
    fun `correct number of luggageIds are generated`() {
        val controller = OrderSubmitHttpController()
        val fiveBags = 5
        val fiveLuggageIds = controller.registerLuggageIds(fiveBags)
        assertEquals(fiveLuggageIds.size, fiveBags)
    }
}