package com.yama.cryptowalletservice.repository

import com.yama.cryptowalletservice.model.user.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
    fun findUserByEmailAndPassword(email: String, password: String): User?
}
