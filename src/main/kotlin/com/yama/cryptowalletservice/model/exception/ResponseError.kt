package com.yama.cryptowalletservice.model.exception

import org.springframework.http.HttpStatus

data class ResponseError(
    val message: String,
    val status: HttpStatus
)
