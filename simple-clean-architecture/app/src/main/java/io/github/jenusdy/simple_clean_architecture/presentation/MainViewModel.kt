package io.github.jenusdy.simple_clean_architecture.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.jenusdy.simple_clean_architecture.domain.MessageEntity
import io.github.jenusdy.simple_clean_architecture.domain.MessageUseCase

class MainViewModel(
    private val messageUseCase: MessageUseCase
) : ViewModel() {
    private val _message = MutableLiveData<MessageEntity>()

    val message: LiveData<MessageEntity> get() = _message

    fun setName(name: String) {
        _message.value = messageUseCase.getMessage(name)
    }
}