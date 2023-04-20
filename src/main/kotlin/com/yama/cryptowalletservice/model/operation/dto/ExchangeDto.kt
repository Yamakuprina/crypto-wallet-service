package com.yama.cryptowalletservice.model.operation.dto

import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import java.util.UUID

class ExchangeDto(
    val userId: UUID,
    val senderWalletBlockchainAddress: String,
    val receiverWalletBlockchainAddress: String,
    val initialCurrency: CryptoCurrency,
    val targetCurrency: CryptoCurrency,
    val transactionAmount: Double
)
