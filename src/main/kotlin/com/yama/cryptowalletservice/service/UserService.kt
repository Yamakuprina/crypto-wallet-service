package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.model.exception.UserNotFound
import com.yama.cryptowalletservice.model.user.UICurrency
import com.yama.cryptowalletservice.model.user.UILanguage
import com.yama.cryptowalletservice.model.user.UITheme
import com.yama.cryptowalletservice.model.user.User
import com.yama.cryptowalletservice.model.user.UserSettings
import com.yama.cryptowalletservice.model.user.dto.SignUpDto
import com.yama.cryptowalletservice.repository.UserRepository
import com.yama.cryptowalletservice.repository.UserSettingsRepository
import com.yama.cryptowalletservice.repository.WalletRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.UUID

@Service
class UserService(
    val userRepository: UserRepository,
    val userSettingsRepository: UserSettingsRepository,
    val walletRepository: WalletRepository,
    val pricesConversionService: PricesConversionService
) {
    val defaultUserSettings = UserSettings(
        id = null,
        language = UILanguage.ENGLISH,
        currency = UICurrency.USD,
        theme = UITheme.LIGHT,
        enableMFA = false
    )

    fun authorize(email: String, password: String): User {
        return userRepository.findUserByEmailAndPassword(email, password) ?: throw UserNotFound()
    }

    fun createUser(signUpDto: SignUpDto): User {
        val settings = userSettingsRepository.save(defaultUserSettings)
        val user = User(
            id = null, signUpDto.fullName, settings, signUpDto.email,
            signUpDto.password, false, 0.0,
            mutableListOf(), mutableListOf()
        )
        return userRepository.save(user)
    }

    fun getUserById(id: UUID): User? {
        return userRepository.findByIdOrNull(id) ?: throw UserNotFound()
    }

    fun deleteUserById(id: UUID) {
        if (getUserById(id) == null) throw UserNotFound()
        userRepository.deleteById(id)
    }

    fun getUserTotalBalance(userId: UUID): Double {
        val user = getUserById(userId)
        val wallets = walletRepository.getWalletsByUserId(userId)
        return pricesConversionService.getTotalBalance(wallets, user!!.userSettings.currency)
    }

    fun updateUserSettings(userId: UUID, newUserSettings: UserSettings): UserSettings {
        val user = getUserById(userId)
        userSettingsRepository.deleteById(user!!.userSettings.id!!)
        user.userSettings = userSettingsRepository.save(newUserSettings)
        return userRepository.save(user).userSettings
    }
}
