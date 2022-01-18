package com.affinityclick.mvvm

import android.app.Application
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import com.affinityclick.mvvm.di.DaggerAppComponent
import dagger.android.DispatchingAndroidInjector

class SampleApplication : Application(), HasAndroidInjector {
  @Inject
  lateinit var fragmentInjector: DispatchingAndroidInjector<Any>

  override fun onCreate() {
    super.onCreate()
    DaggerAppComponent.builder().application(this).build().inject(this)
  }

  override fun androidInjector() = fragmentInjector
}