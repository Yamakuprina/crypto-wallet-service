package com.yama.cryptowalletservice.model.operation

import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import java.time.Instant
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
open class Operation(
    @Id
    @GeneratedValue
    open val id: UUID? = null,
    open val userId: UUID,
    open val walletId: UUID,
    open val senderWalletBlockchainAddress: String,
    open val receiverWalletBlockchainAddress: String,
    open val currency: CryptoCurrency,
    open val transactionAmount: Double,
    open val commissionAmount: Double,
    open var status: OperationStatus,
    open var blockchainOperationHash: String? = null,
    open val timestamp: Long = Instant.now().toEpochMilli()
)
