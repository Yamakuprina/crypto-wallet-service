package com.yama.cryptowalletservice.model.user

import com.yama.cryptowalletservice.model.operation.Operation
import com.yama.cryptowalletservice.model.wallet.Wallet
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.OneToOne
import javax.persistence.Table

@Entity
@Table(name = "users")
data class User(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    var fullName: String,
    @OneToOne
    var userSettings: UserSettings,
    var email: String,
    var password: String,
    var isSubscribed: Boolean,
    var totalBalance: Double,
    @OneToMany
    var wallets: MutableList<Wallet>,
    @OneToMany
    var operationsHistory: MutableList<Operation>
)
