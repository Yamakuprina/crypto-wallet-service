package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.model.exception.UserNotFound
import com.yama.cryptowalletservice.model.wallet.Wallet
import com.yama.cryptowalletservice.model.wallet.dto.WalletDto
import com.yama.cryptowalletservice.repository.WalletRepository
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class WalletService(
    val userService: UserService,
    val walletRepository: WalletRepository,
    val blockchainFacade: BlockchainFacade
) {
    fun createWallet(walletDto: WalletDto): Wallet {
        if (userService.getUserById(walletDto.userId) == null) throw UserNotFound()
        val wallet = Wallet(
            id = null,
            userId = walletDto.userId,
            balance = 0.0,
            blockchainAddress = blockchainFacade.createNewWalletInBlockchain(walletDto.userId, walletDto.currency),
            operationsHistory = mutableListOf(),
            currency = walletDto.currency
        )
        return walletRepository.save(wallet)
    }

    fun getWalletByBlockchainAddress(address: String): Wallet? {
        return walletRepository.getWalletByBlockchainAddressEquals(address)
    }

    fun getWalletsByUserId(userId: UUID): List<Wallet> {
        if (userService.getUserById(userId) == null) throw UserNotFound()
        return walletRepository.getWalletsByUserId(userId)
    }

    fun deleteWalletById(id: UUID) {
        return walletRepository.deleteById(id)
    }
}
