package org.dnltsk.luggagelift.order

import org.dnltsk.luggagelift.model.Costs
import org.dnltsk.luggagelift.model.Currency.EUR
import org.springframework.stereotype.Service

@Service
class CostsService {

    val PRICE_PER_BAG_IN_EUR = Costs(value = 5.0, currency = EUR)

    fun calculateCosts(numberOfBags: Int) : Costs {
        val value = numberOfBags * PRICE_PER_BAG_IN_EUR.value
        return Costs(value = value, currency = PRICE_PER_BAG_IN_EUR.currency)
    }

}