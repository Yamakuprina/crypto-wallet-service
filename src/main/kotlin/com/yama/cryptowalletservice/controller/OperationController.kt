package com.yama.cryptowalletservice.controller

import com.yama.cryptowalletservice.model.operation.ExchangeOperation
import com.yama.cryptowalletservice.model.operation.Operation
import com.yama.cryptowalletservice.model.operation.TransferOperation
import com.yama.cryptowalletservice.model.operation.dto.ExchangeDto
import com.yama.cryptowalletservice.model.operation.dto.TransferDto
import com.yama.cryptowalletservice.service.EmailService
import com.yama.cryptowalletservice.service.OperationService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@Controller
@RequestMapping("/operation")
class OperationController(
    val operationService: OperationService,
    val emailService: EmailService
) {

    @PostMapping("/transfer")
    fun createTransferOperation(@RequestBody transferDto: TransferDto): ResponseEntity<TransferOperation> {
        val operation = operationService.createTransferOperation(transferDto)
        return ResponseEntity(operation, HttpStatus.OK)
    }

    @PostMapping("/exchange")
    fun createExchangeOperation(@RequestBody exchangeDto: ExchangeDto): ResponseEntity<ExchangeOperation> {
        val operation = operationService.createExchangeOperation(exchangeDto)
        return ResponseEntity(operation, HttpStatus.OK)
    }

    @GetMapping("/history")
    fun getOperationsHistory(@RequestParam userId: UUID): ResponseEntity<List<Operation>> {
        return ResponseEntity(operationService.getOperationsByUserId(userId), HttpStatus.OK)
    }

    @GetMapping("/history/file")
    fun getOperationsHistoryFile(@RequestParam userId: UUID): ResponseEntity<ByteArray> {
        return ResponseEntity(operationService.exportOperationsByUserId(userId).readBytes(), HttpStatus.OK)
    }

    @GetMapping("/history/email")
    fun getOperationsHistoryEmail(@RequestParam userId: UUID): ResponseEntity<String> {
        operationService.exportOperationsByUserIdEmail(userId)
        return ResponseEntity("Successfully sent email", HttpStatus.OK)
    }
}
