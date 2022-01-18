package com.affinityclick.mvvm.network

/**
 * A wrapper around a web request that contains information on the state of the request.
 * @param <T> The data we are returning.
</T> */
sealed class FetchResource< out T> {
  object Loading: FetchResource<Nothing>()
  data class Success<out T>(val value: T): FetchResource<T>()
  object Error: FetchResource<Nothing>()
  object Uninitialized: FetchResource<Nothing>()
}