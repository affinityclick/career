package com.affinityclick.mvvm.di

import com.affinityclick.mvvm.movie.credits.MovieCreditsFragment
import com.affinityclick.mvvm.movie.detail.MovieDetailFragment
import com.affinityclick.mvvm.movie.list.topRated.MovieTopRatedListFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class FragmentContributorModule {
  @ContributesAndroidInjector
  abstract fun contributesMovieListFragment(): MovieTopRatedListFragment

  @ContributesAndroidInjector
  abstract fun contributesMovieDetailFragment(): MovieDetailFragment

  @ContributesAndroidInjector
  abstract fun contributesMovieCreditsFragment(): MovieCreditsFragment
}