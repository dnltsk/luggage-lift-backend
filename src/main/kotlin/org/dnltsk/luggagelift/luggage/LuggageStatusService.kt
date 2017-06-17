package org.dnltsk.luggagelift.luggage

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class LuggageStatusService @Autowired constructor(
        val luggageRepository: LuggageRepository
){

    fun loadLuggageStatus(orderId: Int): LuggageStatus{
        return luggageRepository.luggageStatus
    }

    fun updateLuggageStatus(orderId: Int, luggageStatus: LuggageStatus): LuggageStatus {
        luggageRepository.luggageStatus = luggageStatus
        return luggageRepository.luggageStatus
    }

}