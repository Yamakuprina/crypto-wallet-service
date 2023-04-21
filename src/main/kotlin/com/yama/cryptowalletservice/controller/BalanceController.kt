package com.yama.cryptowalletservice.controller

import com.yama.cryptowalletservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@Controller
class BalanceController(
    val userService: UserService
) {
    @GetMapping("/")
    fun index(): String {
        return "index.html"
    }

    @GetMapping("/totalbalance")
    fun getTotalBalance(@RequestParam userId: UUID): ResponseEntity<Double> {
        return ResponseEntity(userService.getUserTotalBalance(userId), HttpStatus.OK)
    }
}
