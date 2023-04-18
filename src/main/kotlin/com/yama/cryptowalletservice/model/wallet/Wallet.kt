package com.yama.cryptowalletservice.model.wallet

import com.yama.cryptowalletservice.model.operation.Operation
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
data class Wallet(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    val userId: UUID,
    var balance: Double,
    val blockchainAddress: String,
    @OneToMany
    var operationsHistory: MutableList<Operation>,
    val currency: CryptoCurrency
) {
}
