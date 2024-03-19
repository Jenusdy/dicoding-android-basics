package io.github.jenusdy.simple_clean_architecture.domain

class MessageInteractor(
    private val repository: IMessageRepository
): MessageUseCase {
    override fun getMessage(name: String): MessageEntity {
        return repository.getWelcomeMessage(name)
    }

}