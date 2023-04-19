package com.yama.cryptowalletservice.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class OperationsController {
    @RequestMapping("/operations")
    fun index(): String {
        return "index.html"
    }
}