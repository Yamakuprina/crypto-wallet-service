package com.yama.cryptowalletservice.controller

import com.yama.cryptowalletservice.model.user.UserSettings
import com.yama.cryptowalletservice.model.user.dto.LoginDto
import com.yama.cryptowalletservice.model.user.dto.SignUpDto
import com.yama.cryptowalletservice.model.user.dto.UserDto
import com.yama.cryptowalletservice.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import java.util.UUID

@Controller
@RequestMapping("/user")
class UserController(
    val userService: UserService
) {
    @GetMapping("/login")
    fun authorize(@RequestBody loginDto: LoginDto): ResponseEntity<UserDto> {
        val user = userService.authorize(loginDto.email, loginDto.password)
        return ResponseEntity(
            UserDto(
                user.id.toString(),
                user.fullName,
                user.userSettings,
                user.isSubscribed,
                user.totalBalance,
                user.wallets,
                user.operationsHistory
            ),
            HttpStatus.OK
        )
    }

    @PostMapping("/signup")
    fun signUp(@RequestBody signUpDto: SignUpDto): ResponseEntity<UserDto> {
        val user = userService.createUser(signUpDto)
        return ResponseEntity(
            UserDto(
                user.id.toString(),
                user.fullName,
                user.userSettings,
                user.isSubscribed,
                user.totalBalance,
                user.wallets,
                user.operationsHistory
            ),
            HttpStatus.OK
        )
    }

    @DeleteMapping("/delete")
    fun deleteUser(@RequestParam id: UUID): ResponseEntity<String> {
        userService.deleteUserById(id)
        return ResponseEntity("Delete success", HttpStatus.OK)
    }

    @PutMapping("/settings")
    fun updateSettings(@RequestParam userId: UUID, userSettings: UserSettings): UserSettings {
        return userService.updateUserSettings(userId, userSettings)
    }
}
