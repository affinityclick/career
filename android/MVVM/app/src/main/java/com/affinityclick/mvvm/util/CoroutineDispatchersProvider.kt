package com.affinityclick.mvvm.util

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ObsoleteCoroutinesApi
import kotlinx.coroutines.newSingleThreadContext
import javax.inject.Inject

data class CoroutineDispatchersProvider(
  val main: CoroutineDispatcher,
  val computation: CoroutineDispatcher,
  val io: CoroutineDispatcher
) {
  @Inject constructor() : this(Dispatchers.Main, Dispatchers.Default, Dispatchers.IO)

  @ObsoleteCoroutinesApi fun newSingleThreadedContext(name: String) = newSingleThreadContext(name)
}
