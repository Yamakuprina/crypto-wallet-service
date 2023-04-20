package com.yama.cryptowalletservice.repository

import com.yama.cryptowalletservice.model.wallet.Wallet
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface WalletRepository : JpaRepository<Wallet, UUID> {
    fun getWalletsByUserId(userId: UUID): List<Wallet>

    fun getWalletByBlockchainAddressEquals(blockchainAddress: String): Wallet?
}
