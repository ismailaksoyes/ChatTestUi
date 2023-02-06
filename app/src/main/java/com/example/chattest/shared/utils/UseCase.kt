package com.example.chattest.shared.utils

import kotlinx.coroutines.flow.Flow

interface NoInputUseCaseWithFlow<out Output> {
    suspend operator fun invoke(): Flow<Output>
}