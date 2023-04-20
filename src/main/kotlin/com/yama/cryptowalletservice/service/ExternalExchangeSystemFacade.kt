package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.model.operation.ExchangeOperation
import org.springframework.stereotype.Service

@Service
class ExternalExchangeSystemFacade {
    fun performExchangeOperation(exchangeOperation: ExchangeOperation): ExchangeOperation {
        return exchangeOperation
    }
}
