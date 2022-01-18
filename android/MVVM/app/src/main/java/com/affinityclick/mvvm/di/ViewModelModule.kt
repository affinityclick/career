package com.affinityclick.mvvm.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.affinityclick.mvvm.di.ViewModelKey
import com.affinityclick.mvvm.movie.list.topRated.MovieTopRatedListViewModel
import com.affinityclick.mvvm.movie.detail.MovieDetailViewModel
import com.affinityclick.mvvm.movie.credits.MovieCreditsViewModel
import com.affinityclick.mvvm.util.ViewModelFactory
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {
  @Binds
  @IntoMap
  @ViewModelKey(MovieTopRatedListViewModel::class)
  abstract fun bindMovieListViewModel(movieListViewModel: MovieTopRatedListViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(MovieDetailViewModel::class)
  abstract fun bindMovieDetailViewModel(movieDetailViewModel: MovieDetailViewModel): ViewModel

  @Binds
  @IntoMap
  @ViewModelKey(MovieCreditsViewModel::class)
  abstract fun bindMovieCreditsViewModel(movieCreditsViewModel: MovieCreditsViewModel): ViewModel

  @Binds
  abstract fun bindViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}