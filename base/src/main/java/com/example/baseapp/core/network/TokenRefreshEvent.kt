package com.example.baseapp.core.events

import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenRefreshEvent @Inject constructor() {
    private val _refreshTokenEvent = MutableSharedFlow<Unit>()
    val refreshTokenEvent: SharedFlow<Unit> = _refreshTokenEvent.asSharedFlow()

    private val refreshMutex = Mutex()
    private var isRefreshing = false

    suspend fun triggerRefreshToken() {
        refreshMutex.withLock {
            if (!isRefreshing) {
                isRefreshing = true
                _refreshTokenEvent.emit(Unit)
                Timber.tag("TokenRefreshEvent").i("Token refresh event triggered")
            } else {
                Timber.tag("TokenRefreshEvent").i("Token refresh already in progress, skipping...")
            }
        }
    }

    fun markRefreshComplete() {
        isRefreshing = false
        Timber.tag("TokenRefreshEvent").i("Token refresh completed")
    }
}
