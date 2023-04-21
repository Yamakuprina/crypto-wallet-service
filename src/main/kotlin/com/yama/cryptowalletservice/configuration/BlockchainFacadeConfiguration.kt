package com.yama.cryptowalletservice.configuration

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "blockchain-facade")
data class BlockchainFacadeConfiguration(
    val url: String
)
