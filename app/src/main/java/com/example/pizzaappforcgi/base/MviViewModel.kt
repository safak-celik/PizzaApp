package com.example.pizzaappforcgi.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class MviViewModel<T : UiIntent, U : UiState>(initialState: U) : ViewModel() {

    private val _uiState = MutableStateFlow(initialState)
    val uiState: StateFlow<U> = _uiState

    private val _uiIntent = MutableSharedFlow<T>(INTENT_REPLAY_AMOUNT)

    init {
        startCollectingUiIntents()
    }

    protected open fun onUiIntent(intent: T) {
        // can be overridden by children implementations
    }

    fun sendIntent(intent: T) {
        viewModelScope.launch { _uiIntent.emit(intent) }
    }

    open fun resendLastIntent() {
        viewModelScope.launch { _uiIntent.replayCache.lastOrNull()?.let { _uiIntent.emit(it) } }
    }

    protected fun publishState(transformation: U.() -> U) {
        _uiState.value = transformation(_uiState.value)
    }

    private fun startCollectingUiIntents() {
        viewModelScope.launch { _uiIntent.collect { onUiIntent(it) } }
    }

    companion object {
        private const val INTENT_REPLAY_AMOUNT = 1
    }
}
