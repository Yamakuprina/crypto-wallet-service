package com.yama.cryptowalletservice.model.operation

import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import java.util.UUID
import javax.persistence.Entity

@Entity
class ExchangeOperation(
    id: UUID? = null,
    userId: UUID,
    walletId: UUID,
    senderWalletBlockchainAddress: String,
    receiverWalletBlockchainAddress: String,
    currency: CryptoCurrency,
    transactionAmount: Double,
    commissionAmount: Double,
    status: OperationStatus,
    var externalSystemId: UUID,
    var targetCurrency: CryptoCurrency,
    var targetAmount: Double
) : Operation(
    id, userId, walletId, senderWalletBlockchainAddress, receiverWalletBlockchainAddress, currency,
    transactionAmount, commissionAmount, status
)
