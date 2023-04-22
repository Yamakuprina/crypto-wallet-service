package com.yama.cryptowalletservice.service

import com.yama.cryptowalletservice.model.email.EmailStatus
import org.springframework.stereotype.Service
import java.io.File

@Service
class EmailService {

    fun sendEmail(email: String, message: String, file: File): EmailStatus {
        return EmailStatus.SUCCESS
    }
}
