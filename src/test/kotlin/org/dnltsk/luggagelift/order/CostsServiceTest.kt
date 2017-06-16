package org.dnltsk.luggagelift.order

import org.junit.Assert.*
import org.junit.Test

class CostsServiceTest{

    @Test
    fun `one bag costs 5 eur`() {
        val oneBag = 1
        val costs = CostsService().calculateCosts(oneBag)
        assertEquals(costs, Costs(5.0, Currency.EUR))
    }

    @Test
    fun `three bags costs 15 eur`() {
        val oneBag = 3
        val costs = CostsService().calculateCosts(oneBag)
        assertEquals(costs, Costs(15.0, Currency.EUR))
    }
}