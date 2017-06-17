package org.dnltsk.luggagelift.order

import org.junit.Assert.assertNotEquals
import org.junit.Test

class OrderResponseHttpControllerTest {

    val costsService = CostsService()
    val pickupSuggestionService = PickupSuggestionService()

    @Test
    fun `new order ids should be randomized`() {
        val controller = OrderHttpController(costsService, pickupSuggestionService)
        val firstNewId = controller.generateOrderId()
        val secondNewId = controller.generateOrderId()
        val thirdNewId = controller.generateOrderId()

        assertNotEquals(firstNewId, secondNewId)
        assertNotEquals(firstNewId, thirdNewId)
    }


}