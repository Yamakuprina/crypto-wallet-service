package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.configuration.BlockchainFacadeConfiguration
import com.yama.cryptowalletservice.model.operation.TransferOperation
import com.yama.cryptowalletservice.model.wallet.CryptoCurrency
import com.yama.cryptowalletservice.model.wallet.Wallet
import com.yama.cryptowalletservice.model.wallet.dto.WalletDto
import com.yama.cryptowalletservice.repository.WalletRepository
import org.springframework.scheduling.annotation.EnableScheduling
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import java.util.UUID

@Service
@EnableScheduling
class BlockchainFacade(
    val walletRepository: WalletRepository,
    val blockchainFacadeConfiguration: BlockchainFacadeConfiguration
) {
    val restTemplate = RestTemplate()
    fun createNewWalletInBlockchain(userId: UUID, currency: CryptoCurrency): String {
        val wallet = restTemplate.postForEntity(
            "${blockchainFacadeConfiguration.url}/wallet",
            WalletDto(id = null, userId, currency),
            Wallet::class.java
        )
        return wallet.body!!.blockchainAddress
//        return UUID.randomUUID().toString()
    }

    @Scheduled(fixedDelay = 60000)
    fun updateWallets() {
        val wallets = walletRepository.findAll()
        wallets.forEach { w -> w.balance += 1 }
        walletRepository.saveAllAndFlush(wallets)
    }

    fun performTransferOperation(transferOperation: TransferOperation): TransferOperation {
        return restTemplate.postForEntity(
            "${blockchainFacadeConfiguration.url}/transfer",
            transferOperation,
            TransferOperation::class.java
        ).body!!
//        return transferOperation
    }
}
