package org.dnltsk.luggagelift.order

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class OrderResponseHttpControllerTest {

    val costsService = CostsService()

    @Test
    fun `new order ids should be randomized`() {
        val firstNewId = OrderHttpController(costsService).generateOrderId()
        val secondNewId = OrderHttpController(costsService).generateOrderId()
        val thirdNewId = OrderHttpController(costsService).generateOrderId()

        assertNotEquals(firstNewId, secondNewId)
        assertNotEquals(firstNewId, thirdNewId)
    }


}