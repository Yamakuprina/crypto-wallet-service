package com.yama.cryptowalletservice.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping

@Controller
class BalanceController {
    @GetMapping("/")
    fun index(): String {
        return "index.html"
    }

    @GetMapping("/total-balance")
    fun getTotalBalance(): Double {
        return 60.0
    }
}
