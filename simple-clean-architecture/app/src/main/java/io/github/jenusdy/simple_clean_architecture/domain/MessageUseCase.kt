package io.github.jenusdy.simple_clean_architecture.domain

interface MessageUseCase {
    fun getMessage(name: String): MessageEntity

}