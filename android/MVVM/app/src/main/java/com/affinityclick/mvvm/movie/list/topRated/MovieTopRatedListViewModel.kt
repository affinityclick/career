package com.affinityclick.mvvm.movie.list.topRated

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.affinityclick.mvvm.network.FetchResource
import com.affinityclick.mvvm.network.TMDBRepository
import com.affinityclick.mvvm.network.models.Movie
import com.affinityclick.mvvm.network.models.PageResult
import javax.inject.Inject

class MovieTopRatedListViewModel @Inject constructor(tmdbRepository: TMDBRepository) : ViewModel() {
  // Using the trigger and switch map lets us observe on one result and update that live data
  // based on calls. See https://www.youtube.com/watch?v=OMcDk2_4LSk&t=4m16s
  private val _moviesTrigger = MutableLiveData<Int>()
  val movieListLiveData: LiveData<FetchResource<PageResult<Movie?>>> =
    Transformations.switchMap(_moviesTrigger) { page: Int ->
      tmdbRepository.getTopRatedMovies(
        page
      )
    }

  fun getMovieList(page: Int) {
    _moviesTrigger.value = page
  }

}