package com.example.curriculogic.ui.ai

import com.example.curriculogic.data.model.ChatMessage

interface AiContract {
    interface View {
        fun showMessages(messages: List<ChatMessage>)
        fun showLoading()
        fun hideLoading()
        fun showError(message: String)
    }

    interface Presenter {
        fun sendMessage(userMessage: String)
    }
}