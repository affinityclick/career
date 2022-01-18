package com.affinityclick.mvvm.movie.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.affinityclick.mvvm.network.FetchResource
import com.affinityclick.mvvm.network.TMDBRepository
import com.affinityclick.mvvm.network.models.Movie
import javax.inject.Inject

class MovieDetailViewModel @Inject constructor(tmdbRepository: TMDBRepository) : ViewModel() {
  // Using the trigger and switch map lets us observe on one result and update that live data
  // based on calls. See https://www.youtube.com/watch?v=OMcDk2_4LSk&t=4m16s
  private val getMovieTrigger = MutableLiveData<Int>()
  val movieLiveData: LiveData<FetchResource<Movie>> =
    Transformations.switchMap(getMovieTrigger) { id: Int -> tmdbRepository.getMovie(id) }

  fun getMovieDetail(id: Int) {
    getMovieTrigger.value = id
  }
}