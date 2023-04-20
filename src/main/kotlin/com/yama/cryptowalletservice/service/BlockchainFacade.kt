package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.model.operation.TransferOperation
import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import com.yama.cryptowalletservice.repository.WalletRepository
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.util.UUID

@Service
@EnableScheduling
class BlockchainFacade(
    val walletRepository: WalletRepository
) {
    fun createNewWalletInBlockchain(userId: UUID, currency: CryptoCurrency): String {
        return UUID.randomUUID().toString()
    }

    @Scheduled(fixedDelay = 60000)
    fun updateWallets() {
        val wallets = walletRepository.findAll()
        wallets.forEach { w -> w.balance += 1 }
        walletRepository.saveAllAndFlush(wallets)
    }

    fun performTransferOperation(transferOperation: TransferOperation): TransferOperation {
        return transferOperation
    }
}
