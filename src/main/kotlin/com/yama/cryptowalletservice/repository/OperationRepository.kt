package com.yama.cryptowalletservice.repository

import com.yama.cryptowalletservice.model.operation.Operation
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface OperationRepository : JpaRepository<Operation, UUID>
