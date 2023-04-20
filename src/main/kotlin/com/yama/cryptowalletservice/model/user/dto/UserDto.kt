package com.yama.cryptowalletservice.model.user.dto

import com.yama.cryptowalletservice.model.operation.Operation
import com.yama.cryptowalletservice.model.user.UserSettings
import com.yama.cryptowalletservice.model.wallet.Wallet

data class UserDto(
    val id: String,
    val fullName: String,
    val userSettings: UserSettings,
    val isSubscribed: Boolean,
    val totalBalance: Double,
    val wallets: MutableList<Wallet>,
    val operationsHistory: MutableList<Operation>
)
