package com.yama.cryptowalletservice.model.user.dto

data class SignUpDto(
    val fullName: String,
    var email: String,
    var password: String
)
