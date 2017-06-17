package org.dnltsk.luggagelift.luggage

import org.springframework.stereotype.Repository

@Repository
class LuggageRepository constructor(
        var luggageStatus: LuggageStatus = LuggageStatus.DRIVER_IN_TRANSIT
){

    fun reset(){
        luggageStatus = LuggageStatus.DRIVER_IN_TRANSIT
    }

}