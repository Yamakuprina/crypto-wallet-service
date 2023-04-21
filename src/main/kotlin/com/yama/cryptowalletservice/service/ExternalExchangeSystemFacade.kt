package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.configuration.ExternalExchangeSystemFacadeConfiguration
import com.yama.cryptowalletservice.model.operation.ExchangeOperation
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate

@Service
class ExternalExchangeSystemFacade(
    val externalExchangeSystemFacadeConfiguration: ExternalExchangeSystemFacadeConfiguration
) {
    val restTemplate = RestTemplate()
    fun performExchangeOperation(exchangeOperation: ExchangeOperation): ExchangeOperation {
//        return restTemplate.postForEntity(
//            "${externalExchangeSystemFacadeConfiguration.url}/exchange",
//            exchangeOperation,
//            ExchangeOperation::class.java
//        ).body!!
        return exchangeOperation
    }
}
