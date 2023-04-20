package com.yama.cryptowalletservice.repository

import com.yama.cryptowalletservice.model.user.UserSettings
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserSettingsRepository : JpaRepository<UserSettings, UUID>
