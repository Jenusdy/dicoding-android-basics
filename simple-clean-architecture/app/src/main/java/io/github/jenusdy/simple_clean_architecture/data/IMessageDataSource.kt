package io.github.jenusdy.simple_clean_architecture.data

import io.github.jenusdy.simple_clean_architecture.domain.MessageEntity

interface IMessageDataSource {

    fun getMessageFromDataSource(name: String) : MessageEntity

}