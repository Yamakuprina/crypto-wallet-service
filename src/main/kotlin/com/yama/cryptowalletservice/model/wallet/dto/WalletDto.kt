package com.yama.cryptowalletservice.model.wallet.dto

import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import java.util.UUID

data class WalletDto(
    val id: UUID? = null,
    val userId: UUID,
    val currency: CryptoCurrency
)
