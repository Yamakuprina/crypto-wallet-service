package com.yama.cryptowalletservice.controller

import com.yama.cryptowalletservice.model.wallet.Wallet
import com.yama.cryptowalletservice.model.wallet.dto.WalletDto
import com.yama.cryptowalletservice.service.WalletService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@Controller
@RequestMapping("/wallet")
class WalletController(
    val walletService: WalletService
) {
    @PostMapping
    fun createWallet(@RequestBody walletDto: WalletDto): ResponseEntity<Wallet> {
        return ResponseEntity(walletService.createWallet(walletDto), HttpStatus.OK)
    }

    @GetMapping
    fun getWalletsByUserId(@RequestParam userId: UUID): ResponseEntity<List<Wallet>> {
        val wallets = walletService.getWalletsByUserId(userId)
        return ResponseEntity(wallets, HttpStatus.OK)
    }

    @DeleteMapping
    fun deleteWalletById(@RequestParam walletId: UUID): ResponseEntity<String> {
        walletService.deleteWalletById(walletId)
        return ResponseEntity("Delete success", HttpStatus.OK)
    }
}
