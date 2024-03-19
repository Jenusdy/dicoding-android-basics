package io.github.jenusdy.simple_clean_architecture.data

import io.github.jenusdy.simple_clean_architecture.domain.IMessageRepository
import io.github.jenusdy.simple_clean_architecture.domain.MessageEntity

class MessageRepository(
    private val messageDataSource: IMessageDataSource
): IMessageRepository {
    override fun getWelcomeMessage(name: String): MessageEntity {
        return messageDataSource.getMessageFromDataSource(name)
    }
}