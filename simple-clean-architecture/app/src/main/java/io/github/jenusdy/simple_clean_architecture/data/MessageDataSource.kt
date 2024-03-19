package io.github.jenusdy.simple_clean_architecture.data

import io.github.jenusdy.simple_clean_architecture.domain.MessageEntity

class MessageDataSource : IMessageDataSource {
    override fun getMessageFromDataSource(name: String): MessageEntity {
        return MessageEntity("Hello $name! Welcome to Clean Architecture")
    }


}