package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.model.exception.OperationCanceled
import com.yama.cryptowalletservice.model.exception.OperationNotFound
import com.yama.cryptowalletservice.model.exception.UserNotFound
import com.yama.cryptowalletservice.model.exception.WalletNotFound
import com.yama.cryptowalletservice.model.operation.ExchangeOperation
import com.yama.cryptowalletservice.model.operation.Operation
import com.yama.cryptowalletservice.model.operation.OperationStatus
import com.yama.cryptowalletservice.model.operation.TransferOperation
import com.yama.cryptowalletservice.model.operation.dto.ExchangeDto
import com.yama.cryptowalletservice.model.operation.dto.TransferDto
import com.yama.cryptowalletservice.repository.OperationRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class OperationService(
    val userService: UserService,
    val operationRepository: OperationRepository,
    val walletService: WalletService,
    val blockchainFacade: BlockchainFacade,
    val externalSystemFacade: ExternalExchangeSystemFacade
) {
    fun createTransferOperation(transferDto: TransferDto): TransferOperation {
        if (userService.getUserById(transferDto.userId) == null) throw UserNotFound()
        val wallet = walletService.getWalletByBlockchainAddress(transferDto.senderWalletBlockchainAddress)
            ?: throw WalletNotFound()
        if (wallet.userId != transferDto.userId || wallet.balance < transferDto.transactionAmount) throw OperationCanceled()
        val transferOperation = TransferOperation(
            id = null,
            userId = transferDto.userId,
            walletId = wallet.id!!,
            senderWalletBlockchainAddress = transferDto.senderWalletBlockchainAddress,
            receiverWalletBlockchainAddress = transferDto.receiverWalletBlockchainAddress,
            currency = transferDto.currency,
            transactionAmount = transferDto.transactionAmount,
            commissionAmount = 0.0,
            status = OperationStatus.IN_PROGRESS
        )
        return operationRepository.save(transferOperation).also {
            blockchainFacade.performTransferOperation(transferOperation)
        }
    }

    fun createExchangeOperation(exchangeDto: ExchangeDto): ExchangeOperation {
        if (userService.getUserById(exchangeDto.userId) == null) throw UserNotFound()
        val wallet = walletService.getWalletByBlockchainAddress(exchangeDto.senderWalletBlockchainAddress)
            ?: throw WalletNotFound()
        if (wallet.userId != exchangeDto.userId || wallet.balance < exchangeDto.transactionAmount) throw OperationCanceled()
        val exchangeOperation = ExchangeOperation(
            id = null,
            userId = exchangeDto.userId,
            walletId = wallet.id!!,
            senderWalletBlockchainAddress = exchangeDto.senderWalletBlockchainAddress,
            receiverWalletBlockchainAddress = exchangeDto.receiverWalletBlockchainAddress,
            currency = exchangeDto.initialCurrency,
            transactionAmount = exchangeDto.transactionAmount,
            commissionAmount = 0.0,
            status = OperationStatus.IN_PROGRESS,
            externalSystemId = null,
            targetCurrency = exchangeDto.targetCurrency,
            targetAmount = exchangeDto.transactionAmount
        )
        return operationRepository.save(exchangeOperation).also {
            externalSystemFacade.performExchangeOperation(exchangeOperation)
        }
    }

    fun getOperationById(operationId: UUID): Operation {
        return operationRepository.findByIdOrNull(operationId) ?: throw OperationNotFound()
    }

    fun getOperationsByUserId(userId: UUID): List<Operation> {
        return operationRepository.getOperationsByUserId(userId)
    }
}
