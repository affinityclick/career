package com.affinityclick.mvvm.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class ViewModelFactory @Inject constructor(
  /**
   * a map that has a Class that extends ViewModel as key, and a Provider
   * of ViewModel (a Dagger 2-specific class that let us to provide — and so
   * instantiate — a dependency-injected class) as value.
   */
  private val creators: Map<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    val creator = creators[modelClass] ?: creators.entries.firstOrNull {
      modelClass.isAssignableFrom(it.key)
    }?.value ?: throw IllegalArgumentException("unknown model class $modelClass")
    @Suppress("UNCHECKED_CAST")
    return creator.get() as T
  }
}