package com.affinityclick.mvvm.di

import android.app.Application
import com.affinityclick.mvvm.SampleApplication
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
  AppModule::class,
  ViewModelModule::class,
  AndroidSupportInjectionModule::class,
  FragmentContributorModule::class
])
interface AppComponent {
  @Component.Builder
  interface Builder {
    @BindsInstance fun application(application: Application): Builder
    fun build(): AppComponent
  }

  fun inject(sampleApplication: SampleApplication)
}