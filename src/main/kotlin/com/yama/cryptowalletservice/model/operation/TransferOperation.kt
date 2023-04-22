package com.yama.cryptowalletservice.model.operation

import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import java.util.UUID
import javax.persistence.Entity

@Entity
class TransferOperation(
    id: UUID? = null,
    userId: UUID,
    walletId: UUID,
    senderWalletBlockchainAddress: String,
    receiverWalletBlockchainAddress: String,
    currency: CryptoCurrency,
    transactionAmount: Double,
    commissionAmount: Double,
    status: OperationStatus
) : Operation(
    id,
    OperationType.TRANSFER,
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
        return "TransferOperation(id=$id, operationType=$operationType, userId=$userId, walletId=$walletId, senderWalletBlockchainAddress='$senderWalletBlockchainAddress', receiverWalletBlockchainAddress='$receiverWalletBlockchainAddress', currency=$currency, transactionAmount=$transactionAmount, commissionAmount=$commissionAmount, status=$status, blockchainOperationHash=$blockchainOperationHash, timestamp=$timestamp)"
    }
}
