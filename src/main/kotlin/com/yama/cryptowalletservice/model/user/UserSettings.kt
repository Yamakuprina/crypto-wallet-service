package com.yama.cryptowalletservice.model.user

import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class UserSettings(
    @Id
    @GeneratedValue
    val id: UUID? = null,
    var language: UILanguage,
    var currency: UICurrency,
    var theme: UITheme,
    var enableMFA: Boolean
)
