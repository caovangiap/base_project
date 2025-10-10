package com.prodigy.feature.girlfriend.model.chat.delete_chat

data class DeleteChatResponse(
    val deletedChat: DeletedChat?,
    val deletedMessages: DeletedMessages?,
    val message: String?
)