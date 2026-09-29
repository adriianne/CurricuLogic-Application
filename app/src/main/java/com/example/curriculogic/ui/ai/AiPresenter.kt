package com.example.curriculogic.ui.ai

import com.example.curriculogic.data.model.ChatMessage

class AiPresenter(private val view: AiContract.View) : AiContract.Presenter {

    private val chatHistory = mutableListOf<ChatMessage>()

    init {
        chatHistory.add(ChatMessage("Hi! I'm your AI Advisor. Ask me anything about your courses.", false))
        view.showMessages(chatHistory)
    }

    override fun sendMessage(userMessage: String) {
        if (userMessage.isBlank()) return

        val userChat = ChatMessage(userMessage, true)
        chatHistory.add(userChat)
        view.showMessages(chatHistory.toList())

        view.showLoading()

        // Placeholder response so we can test the UI first.
        // The real Gemini API call will be added in the next step.
        val aiReply = ChatMessage("I'm still being set up! Ask me again soon.", false)
        chatHistory.add(aiReply)
        view.showMessages(chatHistory.toList())
        view.hideLoading()
    }
}