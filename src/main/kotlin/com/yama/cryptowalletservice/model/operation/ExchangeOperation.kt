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
    var externalSystemId: UUID?,
    var targetCurrency: CryptoCurrency,
    var targetAmount: Double
) : Operation(
    id,
    OperationType.EXCHANGE,
    userId,
    walletId,
    senderWalletBlockchainAddress,
    receiverWalletBlockchainAddress,
    currency,
    transactionAmount,
    commissionAmount,
    status
) {
    override fun toString(): String {
        return "RefillOperation(id=$id, externalSystemId=$externalSystemId, targetCurrency=$targetCurrency, targetAmount=$targetAmount, operationType=$operationType, userId=$userId, walletId=$walletId, senderWalletBlockchainAddress='$senderWalletBlockchainAddress', receiverWalletBlockchainAddress='$receiverWalletBlockchainAddress', currency=$currency, transactionAmount=$transactionAmount, commissionAmount=$commissionAmount, status=$status, blockchainOperationHash=$blockchainOperationHash, timestamp=$timestamp)"
    }
}
