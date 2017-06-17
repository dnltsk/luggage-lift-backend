package org.dnltsk.luggagelift.order

import org.dnltsk.luggagelift.model.Costs
import org.dnltsk.luggagelift.model.Currency.EUR
import org.junit.Assert.assertEquals
import org.junit.Test

class CostsServiceTest{

    @Test
    fun `one bag costs 5 eur`() {
        val oneBag = 1
        val costs = CostsService().calculateCosts(oneBag)
        assertEquals(costs, Costs(5.0, EUR))
    }

    @Test
    fun `three bags costs 15 eur`() {
        val threeBags = 3
        val costs = CostsService().calculateCosts(threeBags)
        assertEquals(costs, Costs(15.0, EUR))
    }
}