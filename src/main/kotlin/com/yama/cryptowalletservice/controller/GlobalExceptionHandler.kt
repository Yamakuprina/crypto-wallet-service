package com.yama.cryptowalletservice.controller

import com.yama.cryptowalletservice.model.exception.EmailException
import com.yama.cryptowalletservice.model.exception.OperationCanceled
import com.yama.cryptowalletservice.model.exception.OperationNotFound
import com.yama.cryptowalletservice.model.exception.ResponseError
import com.yama.cryptowalletservice.model.exception.UserNotFound
import com.yama.cryptowalletservice.model.exception.WalletNotFound
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler
    fun handleOperationNotFound(ex: OperationNotFound): ResponseEntity<ResponseError> {
        val errorMessage = ResponseError(ex.message ?: "Operation not found", HttpStatus.NOT_FOUND)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleUserNotFound(ex: UserNotFound): ResponseEntity<ResponseError> {
        val errorMessage = ResponseError(ex.message ?: "User not found", HttpStatus.NOT_FOUND)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleWalletNotFound(ex: WalletNotFound): ResponseEntity<ResponseError> {
        val errorMessage = ResponseError(ex.message ?: "Wallet not found", HttpStatus.NOT_FOUND)
        return ResponseEntity(errorMessage, HttpStatus.NOT_FOUND)
    }

    @ExceptionHandler
    fun handleOperationCanceled(ex: OperationCanceled): ResponseEntity<ResponseError> {
        val errorMessage = ResponseError(ex.message ?: "Operation could not be performed", HttpStatus.BAD_REQUEST)
        return ResponseEntity(errorMessage, HttpStatus.BAD_REQUEST)
    }

    @ExceptionHandler
    fun handleEmailException(ex: EmailException): ResponseEntity<ResponseError> {
        val errorMessage = ResponseError(ex.message ?: "Email could not be sent", HttpStatus.BAD_REQUEST)
        return ResponseEntity(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR)
    }

}