package org.dnltsk.luggagelift.order

data class OrderResponse constructor(
        val orderId: Int,
        val cost: Costs
)

data class Costs constructor(
        val value: Double,
        val currency: Currency
)

enum class Currency{

    USD, EUR

}