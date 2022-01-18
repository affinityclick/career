package com.affinityclick.mvvm.di

import com.affinityclick.mvvm.network.TMDBApi
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit.Builder
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module(includes = [ViewModelModule::class])
class AppModule {
  @Singleton
  @Provides
  fun provideTMDBApi(): TMDBApi {
    val tmdbRetrofit = Builder()
      .baseUrl("https://api.themoviedb.org/3/")
      .addConverterFactory(GsonConverterFactory.create())
      .client(OkHttpClient().newBuilder().build())
      .build()
    return tmdbRetrofit.create(TMDBApi::class.java)
  }
}