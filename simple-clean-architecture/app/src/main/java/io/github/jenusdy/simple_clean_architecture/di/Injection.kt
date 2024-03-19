package io.github.jenusdy.simple_clean_architecture.di

import io.github.jenusdy.simple_clean_architecture.data.IMessageDataSource
import io.github.jenusdy.simple_clean_architecture.data.MessageDataSource
import io.github.jenusdy.simple_clean_architecture.data.MessageRepository
import io.github.jenusdy.simple_clean_architecture.domain.IMessageRepository
import io.github.jenusdy.simple_clean_architecture.domain.MessageInteractor
import io.github.jenusdy.simple_clean_architecture.domain.MessageUseCase

object Injection {
    fun provideUseCase(): MessageUseCase {
        val messageRepository = provideRepository()
        return MessageInteractor(messageRepository)
    }

    private fun provideRepository(): IMessageRepository {
        val messageDataSource = provideDataSource()
        return MessageRepository(messageDataSource)
    }

    private fun provideDataSource(): IMessageDataSource {
        return MessageDataSource()
    }
}