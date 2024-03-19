package io.github.jenusdy.simple_clean_architecture.domain

interface IMessageRepository {

    fun getWelcomeMessage(name: String): MessageEntity

}