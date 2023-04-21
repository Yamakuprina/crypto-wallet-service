package com.yama.cryptowalletservice.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "exchange-facade")
data class ExternalExchangeSystemFacadeConfiguration(
    val url: String
)
