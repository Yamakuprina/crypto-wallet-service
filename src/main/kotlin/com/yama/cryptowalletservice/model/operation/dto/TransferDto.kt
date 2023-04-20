package com.yama.cryptowalletservice.model.operation.dto

import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import java.util.UUID

data class TransferDto(
    val userId: UUID,
    val senderWalletBlockchainAddress: String,
    val receiverWalletBlockchainAddress: String,
    val currency: CryptoCurrency,
    val transactionAmount: Double
)
