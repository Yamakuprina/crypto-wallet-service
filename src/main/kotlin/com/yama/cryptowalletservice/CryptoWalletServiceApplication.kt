package com.yama.cryptowalletservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationPropertiesScan
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
@EnableConfigurationProperties
@ConfigurationPropertiesScan("com.yama.cryptowalletservice.configuration")
class CryptoWalletServiceApplication

fun main(args: Array<String>) {
    runApplication<CryptoWalletServiceApplication>(*args)
}
